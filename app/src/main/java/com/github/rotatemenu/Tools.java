package com.github.rotatemenu;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

/**
 * ============================================================
 * Copyright：Google有限公司版权所有 (c) 2017
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
 * gitVersion：2.12.0.windows.1
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