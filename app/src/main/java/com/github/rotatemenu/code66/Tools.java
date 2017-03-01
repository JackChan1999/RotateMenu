package com.github.rotatemenu.code66;

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
 * gitVersion： 2.12.0.windows.1
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

	// 隐藏动画
	public static void hideView(ViewGroup view, long delay) {
		RotateAnimation anim = new RotateAnimation(0, 180,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				1f);
		anim.setDuration(500);
		anim.setFillAfter(true);// 保持动画后的状态
		anim.setStartOffset(delay);// 延迟多长时间后才运行动画

		view.startAnimation(anim);

		// 禁用所有孩子的点击事件
		int childCount = view.getChildCount();
		for (int i = 0; i < childCount; i++) {
			view.getChildAt(i).setEnabled(false);// 禁用点击事件
		}
	}

	// 显示动画
	public static void showView(ViewGroup view, long delay) {
		RotateAnimation anim = new RotateAnimation(180, 360,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				1f);
		anim.setDuration(500);
		anim.setFillAfter(true);// 保持动画后的状态
		anim.setStartOffset(delay);// 延迟多长时间后才运行动画

		view.startAnimation(anim);

		// 开启所有孩子的点击事件
		int childCount = view.getChildCount();
		for (int i = 0; i < childCount; i++) {
			view.getChildAt(i).setEnabled(true);// 开启点击事件
		}
	}

}
