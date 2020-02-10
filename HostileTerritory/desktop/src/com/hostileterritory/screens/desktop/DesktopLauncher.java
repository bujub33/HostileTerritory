package com.hostileterritory.screens.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
//import com.hostileterritory.HostileTerritory;
import com.hostileterritory.screens.HostileTerritory;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new HostileTerritory(), config);
	}
}
