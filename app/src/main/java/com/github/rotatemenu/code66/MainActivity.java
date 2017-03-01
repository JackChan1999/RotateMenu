package com.github.rotatemenu.code66;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.github.rotatemenu.R;
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
public class MainActivity extends Activity implements OnClickListener {

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
			if (isLevel2Show) {
				Tools.hideView(rlLevel2);// 隐藏第二层布局
				isLevel2Show = false;

				if (isLevel3Show) {// 如果发现第三次也展现, 也需要隐藏
					Tools.hideView(rlLevel3, 200);// 动画延时200毫秒再运行
					isLevel3Show = false;
				}
			} else {
				Tools.showView(rlLevel2);
				isLevel2Show = true;
			}

			break;
		case R.id.iv_menu:
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

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
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
