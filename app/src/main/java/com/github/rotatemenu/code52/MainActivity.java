package com.github.rotatemenu.code52;

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
public class MainActivity extends Activity implements OnClickListener{
	private String tag = MainActivity.class.getSimpleName();
	private ImageView iv_home,iv_menu;
	private RelativeLayout level1,level2,level3;
	
	private boolean isShowLevel2 = true;//是否显示2级菜单
	private boolean isShowLevel3 = true;//是否显示3级菜单
	
	private boolean isShowMenu = true;//是否显示整个菜单，包括1级，2级，3级的菜单
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
		initListener();
	}

	private void initView() {
		setContentView(R.layout.activity_main);
		iv_home = (ImageView) findViewById(R.id.iv_home);
		iv_menu = (ImageView) findViewById(R.id.iv_menu);
		level1 = (RelativeLayout) findViewById(R.id.rl_level1);
		level2 = (RelativeLayout) findViewById(R.id.rl_level2);
		level3 = (RelativeLayout) findViewById(R.id.rl_level3);
	}
	
	private void initListener() {
		iv_home.setOnClickListener(this);
		iv_menu.setOnClickListener(this);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_MENU){
			
			if(isShowMenu){
				//需要关闭所有菜单
				int startOffset = 0;
				if(isShowLevel3){
					AnimUtil.closeMenu(level3, startOffset);
					isShowLevel3 = false;
					startOffset += 200;
				}
				if(isShowLevel2){
					AnimUtil.closeMenu(level2, startOffset);
					isShowLevel2 = false;
					startOffset += 200;
				}
				
				AnimUtil.closeMenu(level1, startOffset);
				
			}else {
				//需要显示所有菜单
				AnimUtil.showMenu(level1,0);
				AnimUtil.showMenu(level2,200);
				isShowLevel2 = true;
				AnimUtil.showMenu(level3,400);
				isShowLevel3 = true;
				
			}
			isShowMenu = !isShowMenu;
			
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_home:
			if(AnimUtil.animCount!=0){
				//说明有动画在执行
				return;
			}
			if(isShowLevel2){
				//需要隐藏
				int startOffset = 0;
				if(isShowLevel3){
					AnimUtil.closeMenu(level3,startOffset);
					startOffset += 200;
					isShowLevel3 = false;
				}
				
				AnimUtil.closeMenu(level2,startOffset);
			}else{
				//需要显示
//				Log.e(tag, "执行显示操作");
				AnimUtil.showMenu(level2,0);
			}
			isShowLevel2 = !isShowLevel2;
			break;
		case R.id.iv_menu:
			if(AnimUtil.animCount!=0){
				//说明有动画在执行
				return;
			}
			if(isShowLevel3){
				//隐藏3级菜单
				AnimUtil.closeMenu(level3,0);
			}else {
				//显示3级菜单
				AnimUtil.showMenu(level3,0);
			}
			isShowLevel3 = !isShowLevel3;
			break;
		default:
			break;
		}
	}

}
