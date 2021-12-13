package cn.huzhihong.web.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxytest {
    public static void main(String[] args) {
        //1.创建真实对象
        lenovo len = new lenovo();

        //2.动态代理增强len对象
        /**
         * 三个参数
         *     1.类加载器：真实对象..getClass().getClassLoader()
         *     2.接口数组：真实对象.getClass().getInterfaces()
         *     3.处理器：new InvocationHandler()
         */
        SaleComputer proxy_len =  (SaleComputer) Proxy.newProxyInstance(len.getClass().getClassLoader(), len.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//                System.out.println("方法执行力..");
//                System.out.println(method.getName());
                //判断是否是sale方法
                if(method.getName().equals("sale")){
                    //1.增强参数
                    double money = (double) args[0];
                    money = money * 0.85;
                    System.out.println("专车接送，帅");
                    //使用真实对象调用该方法
                    String  obj = (String)method.invoke(len, money);
                    System.out.println("免费送货");
                    //2.增强返回值
                    return obj + "_鼠标垫";
                }else {
                    //1.使用真实对象调用该方法
                    Object invoke = method.invoke(len, args);
                    System.out.println("平穷过");
                    return invoke;
                }
            }
        });

        //2.调用方法
//        proxy_len.show();
//        String computer = proxy_len.sale(7000);
//        System.out.println(computer);
    }
}
