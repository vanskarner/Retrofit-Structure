package vanskarner.android.retrofitstructure.api_service.codeapi;

public class CodeApiSingleton {
    private static CodeApi instance=null;

    private CodeApiSingleton() {
    }

    private static void crearInstance(){
        if (instance==null){
            synchronized (CodeApi.class){
                if (instance==null){
                    instance=new CodeApi();
                }
            }
        }
    }

    public static CodeApi getInstance(){
        if (instance==null)
            crearInstance();
        return instance;
    }
}
