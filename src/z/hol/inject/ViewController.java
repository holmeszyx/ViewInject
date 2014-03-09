package z.hol.inject;

import z.hol.inject.annotation.BindId;
import android.app.Activity;
import android.view.View;

/**
 * View 的控制器
 * 可以使用 {@link BindId} 来标示View
 */
public abstract class ViewController {

    
    public ViewController(Activity activity){
        ViewInject.inject(activity, this);
    }
    
    public ViewController(View root){
        ViewInject.inject(root, this);
    }
}
