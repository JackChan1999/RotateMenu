package com.github.rotatemenu.code56;

import android.view.ViewGroup;
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
 * gitVersion： 2.12.0.windows.1
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 */
public class Tools {

    /**
     * 隐藏传入的View，并且播放旋转动画
     *
     * @param view
     */
    public static void hideView(ViewGroup view) {
        hideView(view, 0);
    }

    /**
     * 显示控件，并且旋转动画
     *
     * @param view
     */
    public static void showView(ViewGroup view) {
        showView(view, 0);
    }

    public static void hideView(ViewGroup view, int startOffset) {
        /**
         * 第一个参数：从那个角度开始旋转
         * 第二个参数：要旋转到的角度
         * 第三个参数：旋转中心的，X轴坐标 第四个参数：旋转中心的，Y轴坐标
         */
        RotateAnimation ra = new RotateAnimation(0, 180, view.getWidth() / 2, view.getHeight());
        ra.setDuration(500);
        ra.setFillAfter(true);// 设置View的状态，出于播放完成的状态
        // 设置多长时间后才播放动画
        ra.setStartOffset(startOffset);
        int childCount = view.getChildCount();
        // 把所有的孩子都叫出来，你们的点击事件都失效吧
        for (int i = 0; i < childCount; i++) {
            view.getChildAt(i).setEnabled(false);//不可用点击
        }

        // view.setEnabled(false);//设置不可用点击
        // view.setVisibility(View.GONE);
        view.startAnimation(ra);

    }

    public static void showView(ViewGroup view, int startOffset) {
        RotateAnimation ra = new RotateAnimation(180, 360, view.getWidth() / 2, view.getHeight());
        ra.setDuration(500);
        ra.setFillAfter(true);// 设置View的状态，出于播放完成的状态
        ra.setStartOffset(startOffset);
        // view.setEnabled(true);//设置不可用点击
        // view.setVisibility(View.VISIBLE);
        // 把所有的孩子都叫出来，你们的点击事件都失效吧
        int childCount = view.getChildCount();
        for (int i = 0; i < childCount; i++) {
            view.getChildAt(i).setEnabled(true);
        }
        view.startAnimation(ra);

    }

}
