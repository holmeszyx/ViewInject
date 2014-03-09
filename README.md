ViewInject
==========

一个结合Annotation的View Inject，简化 findViewById 一类操作。
现在只有最基本的功能。

使用
====

1. 直接使用ViewInject工具类

        - 比如在一个Activity中

        @BindId(R.id.title)
        private TextView txtTitle;

        private void initView(){
            ViewInject.inject(this, this);
        }
        
        - 直接使用View, 如ViewHolder一类

        private static class ViewHolder{
            @BindId(R.id.title)
            private TextView txtTitle;

            public void initView(View root){
                VieInject.inject(root, this);
            }
        }

2. 继承ViewController, 以实现自己的控制器

    
        private static class ViewHolder extends ViewController{
            @BindId(R.id.title)
            private TextView txtTitle;

            public ViewHolder(View root){
                super(root);
            }
        }
