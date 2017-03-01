package com.github.rotatemenu.code52;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
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
 * gitVersion： 2.12.0.windows.1
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 */
public class AnimUtil {
	public static int animCount = 0;//记录当前执行的动画数量
	public static void closeMenu(RelativeLayout rl,int startOffset){
		for (int i = 0; i < rl.getChildCount(); i++) {
			rl.getChildAt(i).setEnabled(false);
		}
		
		//pivotXValue: 0-1
		RotateAnimation animation = new RotateAnimation(0, -180,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 1);
		animation.setDuration(500);
		animation.setFillAfter(true);//动画结束后保持当时的状态
		animation.setStartOffset(startOffset);
		
		animation.setAnimationListener(new MyAnimationListener());
		
		rl.startAnimation(animation);
	}
	
	public static void showMenu(RelativeLayout rl,int startOffset){
		for (int i = 0; i < rl.getChildCount(); i++) {
			rl.getChildAt(i).setEnabled(true);
		}
		
		RotateAnimation animation = new RotateAnimation(-180, 0,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 1);
		animation.setDuration(500);
		animation.setFillAfter(true);//动画结束后保持当时的状态
		animation.setStartOffset(startOffset);
		
		animation.setAnimationListener(new MyAnimationListener());
		
		rl.startAnimation(animation);
	}
	
	static class MyAnimationListener implements AnimationListener{
		@Override
		public void onAnimationStart(Animation animation) {
			animCount++;
		}
		@Override
		public void onAnimationEnd(Animation animation) {
			animCount--;
		}
		@Override
		public void onAnimationRepeat(Animation animation) {
		}
		
	}
}
