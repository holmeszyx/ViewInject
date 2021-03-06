package z.hol.inject;

import java.lang.reflect.Field;

import z.hol.inject.annotation.BindId;
import android.app.Activity;
import android.view.View;

/**
 * View注入器, 与 {@link BindId} 一起使用
 * @author holmes
 *
 */
public class ViewInject {
    
    /**
     * 注入一个Activity对像，绑定其中处于 targetClss 类的View
     * @param activity
     * @param host
     */
    public static void inject(Activity activity, Object host){
        inject(activity, host.getClass(), host);
    }

    /**
     * 注入一个Activity对像，绑定其中的View
     * @param activity
     * @param host
     */
    public static void inject(Activity activity, Class<?> targetClss, Object host){
        final Class<?> clss = targetClss;
        Field[] fields = clss.getDeclaredFields();
        if (fields != null){
            for (int i = 0; i < fields.length; i ++){
                Field field = fields[i];
                if (field.isAnnotationPresent(BindId.class)){
                    int id = field.getAnnotation(BindId.class).value();
                    View v = activity.findViewById(id);
                    if (v != null){
                        field.setAccessible(true);
                        try {
                            field.set(host, v);
                        } catch (IllegalArgumentException e) {
                            // It is Auto-generated catch block
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            // It is Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    /**
     * 注入一个对像，绑定其中的View
     * @param root
     * @param host
     */    
    public static void inject(View root, Object host){
        inject(root, host.getClass(), host);
    } 
    
    /**
     * 注入一个对像，绑定其中处于 targetClss 类下的View
     * @param root
     * @param targetClss
     * @param host
     */    
    public static void inject(View root, Class<?> targetClss, Object host){
        final Class<?> clss = targetClss;
        Field[] fields = clss.getDeclaredFields();
        if (fields != null){
            for (int i = 0; i < fields.length; i ++){
                Field field = fields[i];
                if (field.isAnnotationPresent(BindId.class)){
                    int id = field.getAnnotation(BindId.class).value();
                    View v = root.findViewById(id);
                    if (v != null){
                        field.setAccessible(true);
                        try {
                            field.set(host, v);
                        } catch (IllegalArgumentException e) {
                            // It is Auto-generated catch block
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            // It is Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }    
}
