package ohioclient;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.world.World;
import ohioclient.event.EventManager;

public class OhioClient {
	public String name = "ohioclient", version = "1.0.0", author = "bop";
	public EventManager eventManager;
	public static OhioClient instance = new OhioClient();
	Minecraft mc = Minecraft.getMinecraft();
	
	public void startup() {
		
		eventManager = new EventManager();
		System.out.println("starting " + name + " " + version + " by " + author);
		EventManager.register(this);
		
		mc.loadingScreen.displayLoadingString("be prepared to enter the ohio farmlands.");
		
	} 
	
	public void shutdown() {
		System.out.println("shut up");
		EventManager.unregister(this);
	}
	
	public void joinedWorld(World world) throws InterruptedException {
		Random random = new Random();
		
		while (true) {
			world.setWorldTime(random.nextInt() % 10);
			Thread.sleep(10000);
		}
	}
}
