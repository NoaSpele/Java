package Gamesetup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Gamestates.GameState;
import Gamestates.MainMenu;
import Input.ImageLoader;
import Input.KeyboardChecker;
import Input.MouseChecker;

/**
 * 
 * @author Noa Spele
 * @version 2018-03-20
 *
 */

public class Game implements Runnable {

	private Display display;
	private GameState curState;
	private KeyboardChecker kbc;
	private MouseChecker mc;
	public CardLoader cl;
	public int width, height;
	public String title;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		kbc = new KeyboardChecker();
		mc = new MouseChecker();
	}

	public KeyboardChecker getKBC() {
		return kbc;
	}
	
	public MouseChecker getMC() {
		return mc;
	}
	
	public void setGamestate(GameState state) {
		curState = state;
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getCanvas().createBufferStrategy(3);
		display.getFrame().addKeyListener(kbc);
		display.getFrame().addMouseListener(mc);
		display.getFrame().addMouseMotionListener(mc);
		display.getCanvas().addMouseListener(mc);
		display.getCanvas().addMouseMotionListener(mc);
	}

	private void update(){
		curState.update();
	}

	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		curState.render(g);
		//End Drawing!
		bs.show();
		g.dispose();
	}

	public void run(){

		init();
		playIntro();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if(delta >= 1){
				update();
				render();
				ticks++;
				delta--;
			}

			if(timer >= 1000000000){
				System.out.println("FPS: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();

	}

	private void playIntro() {
		long start = System.nanoTime();
		ImageLoader imLo = new ImageLoader();
		//Draw rapid leaf logo
		while(System.nanoTime()-start < 500000000) {
			bs = display.getCanvas().getBufferStrategy();
			g = bs.getDrawGraphics();
			g.clearRect(0, 0, width, height);
			g.drawImage(imLo.loadImage("/rapidleaf.png"), 0, 0, null);
			bs.show();
			g.dispose();
		}
		cl = new CardLoader();
		//draw magmeda monsters logo
		start = System.nanoTime();
		while(!kbc.checkIfAnyPAR()) {
			bs = display.getCanvas().getBufferStrategy();
			g = bs.getDrawGraphics();
			g.clearRect(0, 0, width, height);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 36));
			g.setColor(Color.BLACK);
			g.drawImage(imLo.loadImage("/magintro.png"), 0, 0, null);
			g.drawString("PRESS ANY KEY TO CONTINUE", 190, 500);
			bs.show();
			g.dispose();
		}
		curState = new MainMenu(this);
	}

	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}