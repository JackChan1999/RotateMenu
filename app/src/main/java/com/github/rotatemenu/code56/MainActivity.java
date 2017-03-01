package com.github.rotatemenu.code56;

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

	private ImageView icon_home;
	private ImageView icon_menu;

	private RelativeLayout level1;
	private RelativeLayout level2;
	private RelativeLayout level3;

	/**
	 * 三级菜单是否显示
	 * true:显示
	 * false:隐藏
	 */
	private boolean isShowLevel3 = true;
	/**
	 * 二级菜单是否显示
	 * true:显示
	 * false:隐藏
	 */
	private boolean isShowLevel2 = true;

	/**
	 * 一级菜单是否显示
	 * true:显示
	 * false:隐藏
	 */
	private boolean isShowLevel1 = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		setListener();
	}

	/**
	 * 设置监听
	 */
	private void setListener() {
		icon_menu.setOnClickListener(this);
		icon_home.setOnClickListener(this);
	}

	/**
	 * 初始化View
	 */
	private void initView() {
		icon_home = (ImageView) findViewById(R.id.iv_home);
		icon_menu = (ImageView) findViewById(R.id.iv_menu);

		level1 = (RelativeLayout) findViewById(R.id.rl_level1);
		level2 = (RelativeLayout) findViewById(R.id.rl_level2);
		level3 = (RelativeLayout) findViewById(R.id.rl_level3);
	}

	/**
	 * 监听物理键
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//监听手机上的菜单按钮
		if(keyCode == KeyEvent.KEYCODE_MENU){
			//判断一级、二级、三级菜单是否显示，如果显示就隐藏
			if(isShowLevel1){
				//隐藏一级菜单

				Tools.hideView(level1);
				isShowLevel1 = false;

				if(isShowLevel2){
					//隐藏二级菜单
					Tools.hideView(level2,200);
					isShowLevel2 = false;

					if(isShowLevel3){
						//隐藏三级菜单
						Tools.hideView(level3,400);
						isShowLevel3 = false;
					}
				}
			}else{
				//判断一级、二级菜单是否隐藏，如果隐藏就显示
				isShowLevel1 = true;
				Tools.showView(level1);

				isShowLevel2  = true;
				Tools.showView(level2,200);
			}
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.iv_menu:// 显示和隐藏三级菜单

				if(isShowLevel3){
					//隐藏
					Tools.hideView(level3);
					isShowLevel3 = false;
				}else{
					//显示
					Tools.showView(level3);
					isShowLevel3  = true;
				}

				break;
			case R.id.iv_home://

				//判断二级菜单和三级菜单是否显示，如果显示就隐藏
				if(isShowLevel2){
					//隐藏
					Tools.hideView(level2);
					isShowLevel2 = false;
					if(isShowLevel3){
						//隐藏
						Tools.hideView(level3,200);
						isShowLevel3 = false;
					}
				}else{
					////判断二级菜单是隐藏，如果隐藏就显示
					Tools.showView(level2);
					isShowLevel2 = true;
				}
				break;

			default:
				break;
		}

	}

}
