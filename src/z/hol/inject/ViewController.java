package z.hol.inject;

import z.hol.inject.annotation.BindId;
import android.app.Activity;
import android.view.View;

/**
 * View 的控制器
 * 可以使用 {@link BindId} 来标示View
 */
public abstract class ViewController {

    /**
     * 这是一个空构造方法,
     * 由子类实现自己的View绑定方法
     */
    protected ViewController(){
        
    }
    
    public ViewController(Activity activity){
        ViewInject.inject(activity, this);
    }
    
    public ViewController(View root){
        ViewInject.inject(root, this);
    }
}
