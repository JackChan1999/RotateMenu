# 项目概述

首先，我们学习如何自定义一个组合控件，其中，优酷菜单是一个典型的自定义组合控件，它的效果图如图1-1 所示：

![](https://github.com/JackChen1999/RotateMenu/blob/master/art/menu9.gif)

![](https://github.com/JackChen1999/RotateMenu/blob/master/art/menu1.png)

图中由中间往外，分别是一级菜单、二级菜单、三级菜单。其基本用法是:点击一级菜单后加载二级菜单，再点击二级菜单加载三级菜单，如图1-2（c）—(d)—（e）—（f），再点击一级菜单分别隐藏三级、二级菜单
1-2（a）—（b）。并且点击手机菜单键，让菜单根据状态来显示和隐藏，演示效果图如图1-2 所示。

![](https://github.com/JackChen1999/RotateMenu/blob/master/art/menu2.png) ![](https://github.com/JackChen1999/RotateMenu/blob/master/art/menu3.png)

![](https://github.com/JackChen1999/RotateMenu/blob/master/art/menu4.png) ![](https://github.com/JackChen1999/RotateMenu/blob/master/art/menu5.png)

![](https://github.com/JackChen1999/RotateMenu/blob/master/art/menu6.png) ![](https://github.com/JackChen1999/RotateMenu/blob/master/art/menu7.png)


# 优酷菜单UI


优酷菜单的整体布局采用RelativeLayout，每一级菜单都是一个RelativeLayout。优酷菜单的布局文件activity_main.xml，具体的代码如文件【1-1】所示：
【文件1-1】activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:tools="http://schemas.android.com/tools"
                android:layout_width="match_parent"
                android:layout_height="match_parent">
    <!--三级菜单-->
    <RelativeLayout
        android:id="@+id/rl_level3"
        android:layout_width="280dp"
        android:layout_height="140dp"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:background="@drawable/level3">

        <ImageView
            android:id="@+id/iv_channel1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_margin="10dp"
            android:src="@drawable/channel1"/>

        <ImageView
            android:id="@+id/iv_channel2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_above="@id/iv_channel1"
            android:layout_alignLeft="@id/iv_channel1"
            android:layout_marginBottom="5dp"
            android:layout_marginLeft="25dp"
            android:src="@drawable/channel2"/>

        <ImageView
            android:id="@+id/iv_channel3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_above="@id/iv_channel2"
            android:layout_alignLeft="@id/iv_channel2"
            android:layout_marginBottom="5dp"
            android:layout_marginLeft="35dp"
            android:src="@drawable/channel3"/>

        <ImageView
            android:id="@+id/iv_channel4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentTop="true"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="5dp"
            android:src="@drawable/channel4"/>

        <ImageView
            android:id="@+id/iv_channel7"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_alignParentRight="true"
            android:layout_margin="10dp"
            android:src="@drawable/channel7"/>

        <ImageView
            android:id="@+id/iv_channel6"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_above="@id/iv_channel7"
            android:layout_alignRight="@id/iv_channel7"
            android:layout_marginBottom="5dp"
            android:layout_marginRight="25dp"
            android:src="@drawable/channel6"/>

        <ImageView
            android:id="@+id/iv_channel5"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_above="@id/iv_channel6"
            android:layout_alignRight="@id/iv_channel6"
            android:layout_marginBottom="5dp"
            android:layout_marginRight="35dp"
            android:src="@drawable/channel5"/>
    </RelativeLayout>

    <!--二级菜单-->
    <RelativeLayout
        android:id="@+id/rl_level2"
        android:layout_width="180dp"
        android:layout_height="90dp"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:background="@drawable/level2">

        <ImageView
            android:id="@+id/imageView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_margin="10dp"
            android:src="@drawable/icon_search"/>

        <ImageView
            android:id="@+id/iv_menu"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentTop="true"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="5dp"
            android:src="@drawable/icon_menu"/>

        <ImageView
            android:id="@+id/imageView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_alignParentRight="true"
            android:layout_margin="10dp"
            android:src="@drawable/icon_myyouku"/>
    </RelativeLayout>

    <!--二级菜单-->
    <RelativeLayout
        android:id="@+id/rl_level1"
        android:layout_width="100dp"
        android:layout_height="50dp"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:background="@drawable/level1">

        <ImageView
            android:id="@+id/iv_home"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerHorizontal="true"
            android:layout_centerVertical="true"
            android:src="@drawable/icon_home"/>
    </RelativeLayout>
</RelativeLayout>
```
运行程序，效果图如图1-3 所示

![](https://github.com/JackChen1999/RotateMenu/blob/master/art/menu8.png)

# 优酷菜单业务逻辑实现

布局UI 实现之后，我们需要实现优酷菜单的业务逻辑代码，具体代码如文件【1-2】所示：【文件1-2】com.itheima.youku.MainActivity

```java
package com.github.rotatemenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * ============================================================
 * Copyright：${TODO}有限公司版权所有 (c) 2017
 * Author：   AllenIverson
 * Email：    815712739@qq.com
 * GitHub：   https://github.com/JackChen1999
 * 博客：     http://blog.csdn.net/axi295309066
 * 微博：     AndroidDeveloper
 * <p>
 * Project_Name：RotateMenu
 * Package_Name：com.github.rotatemenu
 * Version：1.0
 * time：2016/2/28 21:47
 * des ：三级旋转菜单
 * gitVersion：$Rev$
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private RelativeLayout rlLevel1, rlLevel2, rlLevel3;
    private boolean isLevel1Show = true;
    private boolean isLevel2Show = true;
    private boolean isLevel3Show = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView ivHome = (ImageView) findViewById(R.id.iv_home);
        ImageView ivMenu = (ImageView) findViewById(R.id.iv_menu);
        rlLevel1 = (RelativeLayout) findViewById(R.id.rl_level1);
        rlLevel2 = (RelativeLayout) findViewById(R.id.rl_level2);
        rlLevel3 = (RelativeLayout) findViewById(R.id.rl_level3);
        ivHome.setOnClickListener(this);
        ivMenu.setOnClickListener(this);
        // 为了避免第三层布局将一二层事件拦截掉, 需要在布局文件中最先注册第三层, 最后注册第一层
        rlLevel3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_home:
                System.out.println("home clicked!");
                if (Tools.mAnimtionNum != 0) {
                    break;
                }

                if (isLevel2Show) {
                    Tools.hideView(rlLevel2);// 隐藏第二层布局
                    isLevel2Show = false;
                    if (isLevel3Show) {// 如果发现第三次也展现, 也需要隐藏
                        Tools.hideView(rlLevel3, 200);// 动画延时200 毫秒再运行
                        isLevel3Show = false;
                    }
                } else {
                    Tools.showView(rlLevel2);
                    isLevel2Show = true;
                }
                break;
            case R.id.iv_menu:
                if (Tools.mAnimtionNum != 0) {
                    break;
                }
                System.out.println("menu clicked!");
                if (isLevel3Show) {
                    Tools.hideView(rlLevel3);
                    isLevel3Show = false;
                } else {
                    Tools.showView(rlLevel3);
                    isLevel3Show = true;
                }
                break;
            default:
                break;
        }
    }
    //监听用户的物理按键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            if (Tools.mAnimtionNum != 0) {
                return true;
            }
            if (isLevel1Show) {
                Tools.hideView(rlLevel1);
                isLevel1Show = false;
                if (isLevel2Show) {
                    Tools.hideView(rlLevel2, 200);
                    isLevel2Show = false;
                }
                if (isLevel3Show) {
                    Tools.hideView(rlLevel3, 300);

                    isLevel3Show = false;
                }
            } else {
                Tools.showView(rlLevel1);
                isLevel1Show = true;
                Tools.showView(rlLevel2, 200);
                isLevel2Show = true;
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
```

# Tools 工具类的逻辑实现

为了隐藏View 和显示View，在工具类Tools.java 中定义了两个方法，具体代码如文件【】所示：【文件1-3】com.itheima.youku.Tools

```java
package com.github.rotatemenu;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

/**
 * ============================================================
 * Copyright：${TODO}有限公司版权所有 (c) 2017
 * Author：   AllenIverson
 * Email：    815712739@qq.com
 * GitHub：   https://github.com/JackChen1999
 * 博客：     http://blog.csdn.net/axi295309066
 * 微博：     AndroidDeveloper
 * <p>
 * Project_Name：RotateMenu
 * Package_Name：com.github.rotatemenu
 * Version：1.0
 * time：2016/2/28 21:47
 * des ：三级旋转菜单
 * gitVersion：$Rev$
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 */

public class Tools {
    public static void hideView(ViewGroup view) {
        hideView(view, 0);
    }

    public static void showView(ViewGroup view) {
        showView(view, 0);
    }

    public static int mAnimtionNum = 0; //用于记录当前正在执行的动画个数

    /**
     * 隐藏动画
     *
     * @param view  将要执行动画的视图
     * @param delay 动画要延迟执行的时间
     */
    public static void hideView(ViewGroup view, long delay) {
        /**
         * 第一个参数： fromDegrees 起始角度，这里我们设置为0
         * 第二个参数: toDegrees 目标角度，这里设置为180 度
         * 第三个参数: pivotXType 相对于X 坐标类型，这里是相对于自己
         * 第四个参数: pivotXValue 相对于X 坐标类型的值，这里是0.5f,也就是X 轴的一半
         * 第五个参数: pivotYType 相对于Y 坐标类型，这里是相对于自己
         * 第六个参数: pivotYValue 相对于Y 坐标类型的值，这里是1.f,也就是Y 坐标最大处
         * RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType,
         pivotYValue)
         */
        RotateAnimation anim = new RotateAnimation(0, 180,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f);
        anim.setDuration(500); //动画执行时间
        anim.setFillAfter(true); // 保持动画后的状态
        anim.setStartOffset(delay); // 延迟多长时间后才运行动画
        anim.setAnimationListener(new MyAnimationListener());
        view.startAnimation(anim);
        // 禁用所有孩子的点击事件
        int childCount = view.getChildCount();
        for (int i = 0; i < childCount; i++) {
            view.getChildAt(i).setEnabled(false); // 禁用点击事件
        }
    }

    /**
     * 显示动画
     *
     * @param view  将要执行动画的视图
     * @param delay 动画要延迟执行的时间
     */
    public static void showView(ViewGroup view, long delay) {
        RotateAnimation anim = new RotateAnimation(180, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f);
        anim.setDuration(500);
        anim.setFillAfter(true); // 保持动画后的状态
        anim.setStartOffset(delay); // 延迟多长时间后才运行动画
        anim.setAnimationListener(new MyAnimationListener());
        view.startAnimation(anim);
        // 开启所有孩子的点击事件
        int childCount = view.getChildCount();
        for (int i = 0; i < childCount; i++) {
            view.getChildAt(i).setEnabled(true);// 开启点击事件
        }
    }

    public static class MyAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {
            mAnimtionNum++;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            mAnimtionNum--;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
```

# 知识点总结

1．补间动画不能改变控件的实际位置，控件还是能够响应原先的事件。在菜单隐藏后还会响应点击事件，因此在Tools.java 的第32 到36 行在隐藏菜单时，通过遍历相对布局的子控件，设置其为不可用来解决此bug，
在显示菜单时，第51 到55 行通过遍历相对布局的子控件，设置为可用。

2．连续点击菜单时，优酷菜单动画会直接执行，产生一个隐藏动画还没执行完，就执行显示动画的bug，因此在Tools.java 的隐藏和显示动画中都设置了动画监听MyAnimationListener，在点击菜单时，先判断Tools
的动画数量mAnimtionNum（Tools.java 第8 行）是否为0，再执行下一个动画，来解决bug。