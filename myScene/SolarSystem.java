/*
 * CO2016 Coursework 4
 * By Liam Wilcox (LW306)
 */

import com.sun.j3d.utils.universe.*;

import javax.imageio.ImageIO;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;
import java.io.IOException;

import com.sun.j3d.utils.behaviors.mouse.*; 
import javax.swing.JFrame;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;

public class SolarSystem extends JFrame {

	// Increase/decrease to change speeds of orbits (The bigger it is, the faster it is)
	private final int orbitTimeScale = 10000000;
	// Increase/decrease to change speeds of rotations (The bigger it is, the faster it is)
	private final int dayTimeScale = 10000;

	public BranchGroup createSceneGraph() throws IOException {

		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 1000.0);

		BranchGroup objRoot = new BranchGroup();

		TransformGroup mainTG = new TransformGroup();
		mainTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		mainTG.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		TransformGroup TGA = new TransformGroup();
		TGA.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		TGA.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);		

		objRoot.addChild(mainTG);
		mainTG.addChild(TGA);

		Transform3D yAxis = new Transform3D();
		Transform3D zAxis = new Transform3D();
		
		// Allspark Transformations
		Alpha allsparkOrbitAlpha = new Alpha(-1, (int) (76030000000.0/orbitTimeScale));
		TransformGroup allsparkRotGroup = new TransformGroup();
		allsparkRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		allsparkRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		RotationInterpolator allsparkRotator = new RotationInterpolator(allsparkOrbitAlpha, allsparkRotGroup, zAxis, 0.0f, (float) Math.PI * (2.0f));
		allsparkRotator.setSchedulingBounds(bounds);
		allsparkRotGroup.addChild(allsparkRotator);
		
		// Sun Transformations
		Transform3D sunTransformation = new Transform3D();
		TransformGroup sunGroup = new TransformGroup(sunTransformation);

		// Mercury Transformations
		Alpha mercuryOrbitAlpha = new Alpha(-1, (int) (7603000000.0/orbitTimeScale));
		Alpha mercurySpinAlpha = new Alpha(-1, (int) (5068800000.0/dayTimeScale));
		Transform3D mercuryTransformation = new Transform3D();
		mercuryTransformation.setTranslation(new Vector3d(0.0, 0.0 ,-11.5));
		TransformGroup mercuryRotGroup = new TransformGroup();
		TransformGroup mercuryRotGroup2 = new TransformGroup();
		TransformGroup mercuryTranGroup = new TransformGroup(mercuryTransformation);
		mercuryRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		mercuryRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		mercuryRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		mercuryRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		RotationInterpolator mercuryRotator = new RotationInterpolator(mercuryOrbitAlpha, mercuryRotGroup, zAxis, 0.0f, (float) Math.PI * (2.0f));
		RotationInterpolator mercuryRotator2 = new RotationInterpolator(mercurySpinAlpha, mercuryRotGroup2, zAxis, 0.0f, (float) Math.PI * (2.0f));
		mercuryRotator.setSchedulingBounds(bounds);
		mercuryRotator2.setSchedulingBounds(bounds);
		mercuryRotGroup.addChild(mercuryRotator);
		mercuryRotGroup2.addChild(mercuryRotator2);

		// Venus Transformations
		Alpha venusOrbitAlpha = new Alpha(-1, (int) (19353000000.0/orbitTimeScale));
		Alpha venusSpinAlpha = new Alpha(-1, (int) (20995200000.0/dayTimeScale));
		Transform3D venusTransformation = new Transform3D();
		venusTransformation.setTranslation(new Vector3d(0.0, 0.0 ,-17));
		TransformGroup venusTranGroup = new TransformGroup(venusTransformation);
		TransformGroup venusRotGroup = new TransformGroup();
		TransformGroup venusRotGroup2 = new TransformGroup();
		venusRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		venusRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		venusRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		venusRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		RotationInterpolator venusRotator = new RotationInterpolator(venusOrbitAlpha, venusRotGroup, zAxis, 0.0f, (float) Math.PI * (2.0f));
		RotationInterpolator venusRotator2 = new RotationInterpolator(venusSpinAlpha, venusRotGroup2, zAxis, 0.0f, (float) Math.PI * (2.0f));
		venusRotator.setSchedulingBounds(bounds);
		venusRotator2.setSchedulingBounds(bounds);
		venusRotGroup.addChild(venusRotator);
		venusRotGroup2.addChild(venusRotator2);

		// Earth Transformations
		Alpha earthOrbitAlpha = new Alpha(-1, (int) (31536000000.0/orbitTimeScale));
		Alpha earthSpinAlpha = new Alpha(-1, (int) (86400000.0/dayTimeScale));
		Transform3D earthTransformation = new Transform3D();
		earthTransformation.setTranslation(new Vector3d(0.0, 0.0 ,-22.5));
		TransformGroup earthTranGroup = new TransformGroup(earthTransformation);
		TransformGroup earthRotGroup = new TransformGroup();
		TransformGroup earthRotGroup2 = new TransformGroup();
		earthRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		earthRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		earthRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		earthRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		RotationInterpolator earthRotator = new RotationInterpolator(earthOrbitAlpha, earthRotGroup, zAxis, 0.0f, (float) Math.PI * (2.0f));
		RotationInterpolator earthRotator2 = new RotationInterpolator(earthSpinAlpha, earthRotGroup2, zAxis, 0.0f, (float) Math.PI * (2.0f));
		earthRotator.setSchedulingBounds(bounds);
		earthRotator2.setSchedulingBounds(bounds);
		earthRotGroup.addChild(earthRotator);
		earthRotGroup2.addChild(earthRotator2);

		// Mars Transformations
		Alpha marsOrbitAlpha = new Alpha(-1, (int) (59356000000.0/orbitTimeScale));
		Alpha marsSpinAlpha = new Alpha(-1, (int) (90000000.0/dayTimeScale));
		Transform3D marsTransformation = new Transform3D();
		marsTransformation.setTranslation(new Vector3d(0.0, 0.0 ,-29));
		TransformGroup marsTranGroup = new TransformGroup(marsTransformation);
		TransformGroup marsRotGroup = new TransformGroup();
		TransformGroup marsRotGroup2 = new TransformGroup();
		marsRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		marsRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		marsRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		marsRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		RotationInterpolator marsRotator = new RotationInterpolator(marsOrbitAlpha, marsRotGroup, zAxis, 0.0f, (float) Math.PI * (2.0f));
		RotationInterpolator marsRotator2 = new RotationInterpolator(marsSpinAlpha, marsRotGroup2, zAxis, 0.0f, (float) Math.PI * (2.0f));
		marsRotator.setSchedulingBounds(bounds);
		marsRotator2.setSchedulingBounds(bounds);
		marsRotGroup.addChild(marsRotator);
		marsRotGroup2.addChild(marsRotator2);

		// Jupiter Transformations
		Alpha jupiterOrbitAlpha = new Alpha(-1, (int) (374284000000.0/orbitTimeScale));
		Alpha jupiterSpinAlpha = new Alpha(-1, (int) (36000000.0/dayTimeScale));
		Transform3D jupiterTransformation = new Transform3D();
		jupiterTransformation.setTranslation(new Vector3d(0.0, 0.0 ,-37));
		TransformGroup jupiterTranGroup = new TransformGroup(jupiterTransformation);
		TransformGroup jupiterRotGroup = new TransformGroup();
		TransformGroup jupiterRotGroup2 = new TransformGroup();
		jupiterRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		jupiterRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		jupiterRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		jupiterRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		RotationInterpolator jupiterRotator = new RotationInterpolator(jupiterOrbitAlpha, jupiterRotGroup, zAxis, 0.0f, (float) Math.PI * (2.0f));
		RotationInterpolator jupiterRotator2 = new RotationInterpolator(jupiterSpinAlpha, jupiterRotGroup2, zAxis, 0.0f, (float) Math.PI * (2.0f));
		jupiterRotator.setSchedulingBounds(bounds);
		jupiterRotator2.setSchedulingBounds(bounds);
		jupiterRotGroup.addChild(jupiterRotator);
		jupiterRotGroup2.addChild(jupiterRotator2);

		// Saturn Transformations
		Alpha saturnOrbitAlpha = new Alpha(-1, (int) (929977000000.0/orbitTimeScale));
		Alpha saturnSpinAlpha = new Alpha(-1, (int) (39600000.0/dayTimeScale));
		Transform3D saturnTransformation = new Transform3D();
		saturnTransformation.setTranslation(new Vector3d(0.0, 0.0 ,44));
		TransformGroup saturnTranGroup = new TransformGroup(saturnTransformation);
		TransformGroup saturnRotGroup = new TransformGroup();
		TransformGroup saturnRotGroup2 = new TransformGroup();
		saturnRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		saturnRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		saturnRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		saturnRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		RotationInterpolator saturnRotator = new RotationInterpolator(saturnOrbitAlpha, saturnRotGroup, zAxis, 0.0f, (float) Math.PI * (2.0f));
		RotationInterpolator saturnRotator2 = new RotationInterpolator(saturnSpinAlpha, saturnRotGroup2, zAxis, 0.0f, (float) Math.PI * (2.0f));
		saturnRotator.setSchedulingBounds(bounds);
		saturnRotator2.setSchedulingBounds(bounds);
		saturnRotGroup.addChild(saturnRotator);
		saturnRotGroup2.addChild(saturnRotator2);

		// Uranus Transformations
		Alpha uranusOrbitAlpha = new Alpha(-1, (int) (2651443000000.0/orbitTimeScale));
		Alpha uranusSpinAlpha = new Alpha(-1, (int) (61200000.0/dayTimeScale));
		Transform3D uranusTransformation = new Transform3D();
		uranusTransformation.setTranslation(new Vector3d(0.0, 0.0 ,-52));
		TransformGroup uranusTranGroup = new TransformGroup(uranusTransformation);
		TransformGroup uranusRotGroup = new TransformGroup();
		TransformGroup uranusRotGroup2 = new TransformGroup();
		uranusRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		uranusRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		uranusRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		uranusRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		RotationInterpolator uranusRotator = new RotationInterpolator(uranusOrbitAlpha, uranusRotGroup, zAxis, 0.0f, (float) Math.PI * (2.0f));
		RotationInterpolator uranusRotator2 = new RotationInterpolator(uranusSpinAlpha, uranusRotGroup2, zAxis, 0.0f, (float) Math.PI * (2.0f));
		uranusRotator.setSchedulingBounds(bounds);
		uranusRotator2.setSchedulingBounds(bounds);
		uranusRotGroup.addChild(uranusRotator);
		uranusRotGroup2.addChild(uranusRotator2);

		// Neptune Transformations
		Alpha neptuneOrbitAlpha = new Alpha(-1, (int) (5199724000000.0/orbitTimeScale));
		Alpha neptuneSpinAlpha = new Alpha(-1, (int) (57600000.0/dayTimeScale));
		Transform3D neptuneTransformation = new Transform3D();
		neptuneTransformation.setTranslation(new Vector3d(0.0, 0.0 ,57.5));
		TransformGroup neptuneTranGroup = new TransformGroup(neptuneTransformation);
		TransformGroup neptuneRotGroup = new TransformGroup();
		TransformGroup neptuneRotGroup2 = new TransformGroup();
		neptuneRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		neptuneRotGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		neptuneRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		neptuneRotGroup2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		RotationInterpolator neptuneRotator = new RotationInterpolator(neptuneOrbitAlpha, neptuneRotGroup, zAxis, 0.0f, (float) Math.PI * (2.0f));
		RotationInterpolator neptuneRotator2 = new RotationInterpolator(neptuneSpinAlpha, neptuneRotGroup2, zAxis, 0.0f, (float) Math.PI * (2.0f));
		neptuneRotator.setSchedulingBounds(bounds);
		neptuneRotator2.setSchedulingBounds(bounds);
		neptuneRotGroup.addChild(neptuneRotator);
		neptuneRotGroup2.addChild(neptuneRotator2);
		
		Transform3D allsparkTran = new Transform3D();
		allsparkTran.setTranslation(new Vector3d(0.0,0.0,63.0));
		TransformGroup allsparkGroup = new TransformGroup(allsparkTran);

		int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
		TextureAttributes texAttr = new TextureAttributes();
		texAttr.setTextureMode(TextureAttributes.REPLACE);

		BoundingSphere bounds2 =	new BoundingSphere (new Point3d (2, 2, 4), 5000.0);
		Color3f lightColor = new Color3f (1.0f, 1.0f, 1.0f);
		Vector3f light1Direction = new Vector3f (0.0f, 0.0f, 1f);
		DirectionalLight light1  = new DirectionalLight (lightColor, light1Direction);
		light1.setInfluencingBounds(bounds2);
		TGA.addChild (light1);

		AmbientLight ambientLightNode = new AmbientLight(lightColor);
		ambientLightNode.setInfluencingBounds (bounds2);
		TGA.addChild(ambientLightNode);

		// Background Appearance
		TextureLoader loader = new  TextureLoader(ImageIO.read(getClass().getResource("Textures/background.jpg")),this);
		ImageComponent2D image = loader.getImage( );
		Background background = new Background();
		background.setImage(image);
		background.setApplicationBounds(bounds);
		TGA.addChild(background);

		// Allspark Appearance
		Appearance allsparkApp = new Appearance();
		Box allspark = new Box(2.0f, 2.0f, 2.0f, primflags, allsparkApp);
		Texture allsparkTexture = new TextureLoader(ImageIO.read(getClass().getResource("Textures/allspark.jpg"))).getTexture();
		allsparkTexture.setBoundaryModeS(Texture.WRAP);
		allsparkTexture.setBoundaryModeT(Texture.WRAP);
		allsparkApp.setTexture(allsparkTexture);
		allsparkApp.setTextureAttributes(texAttr);
		allspark.setAppearance(allsparkApp);

		// Sun Appearance
		Appearance sunApp = new Appearance();
		Sphere sun = new Sphere(7.0f, primflags, 100, sunApp);
		Texture sunTexture = new TextureLoader(ImageIO.read(getClass().getResource("Textures/sunmap.jpg"))).getTexture();
		sunTexture.setBoundaryModeS(Texture.WRAP);
		sunTexture.setBoundaryModeT(Texture.WRAP);
		sunApp.setTexture(sunTexture);
		sunApp.setTextureAttributes(texAttr);
		sun.setAppearance(sunApp);

		// Mercury Appearance
		Appearance mercuryApp = new Appearance();
		Sphere mercury = new Sphere(1.0f, primflags, 100, mercuryApp);
		Texture mercuryTexture = new TextureLoader(ImageIO.read(getClass().getResource("Textures/mercurymap.jpg"))).getTexture();
		mercuryTexture.setBoundaryModeS(Texture.WRAP);
		mercuryTexture.setBoundaryModeT(Texture.WRAP);
		mercuryApp.setTexture(mercuryTexture);
		mercuryApp.setTextureAttributes(texAttr);
		mercury.setAppearance(mercuryApp);

		// Venus Appearance
		Appearance venusApp = new Appearance();
		Sphere venus = new Sphere(1.2f, primflags, 100, venusApp);
		Texture venusTexture = new TextureLoader(ImageIO.read(getClass().getResource("Textures/venusmap.jpg"))).getTexture();
		venusTexture.setBoundaryModeS(Texture.WRAP);
		venusTexture.setBoundaryModeT(Texture.WRAP);
		venusApp.setTexture(venusTexture);
		venusApp.setTextureAttributes(texAttr);
		venus.setAppearance(venusApp);

		// Earth Appearance
		Appearance earthApp = new Appearance();
		Sphere earth = new Sphere(1.5f, primflags, 100, earthApp);
		Texture earthTexture = new TextureLoader(ImageIO.read(getClass().getResource("Textures/earthmap1k.jpg"))).getTexture();
		earthTexture.setBoundaryModeS(Texture.WRAP);
		earthTexture.setBoundaryModeT(Texture.WRAP);
		earthApp.setTexture(earthTexture);
		earthApp.setTextureAttributes(texAttr);
		earth.setAppearance(earthApp);

		// Mars Appearance
		Appearance marsApp = new Appearance();
		Sphere mars = new Sphere(1.3f, primflags, 100, marsApp);
		Texture marsTexture = new TextureLoader(ImageIO.read(getClass().getResource("Textures/mars_1k_color.jpg"))).getTexture();
		marsTexture.setBoundaryModeS(Texture.WRAP);
		marsTexture.setBoundaryModeT(Texture.WRAP);
		marsApp.setTexture(marsTexture);
		marsApp.setTextureAttributes(texAttr);
		mars.setAppearance(marsApp);

		// Jupiter Appearance
		Appearance jupiterApp = new Appearance();
		Sphere jupiter = new Sphere(2.1f, primflags, 100, jupiterApp);
		Texture jupiterTexture = new TextureLoader(ImageIO.read(getClass().getResource("Textures/jupitermap.jpg"))).getTexture();
		jupiterTexture.setBoundaryModeS(Texture.WRAP);
		jupiterTexture.setBoundaryModeT(Texture.WRAP);
		jupiterApp.setTexture(jupiterTexture);
		jupiterApp.setTextureAttributes(texAttr);
		jupiter.setAppearance(jupiterApp);

		// Saturn Appearance
		Appearance saturnApp = new Appearance();
		Sphere saturn = new Sphere(1.9f, primflags, 100, saturnApp);
		Texture saturnTexture = new TextureLoader(ImageIO.read(getClass().getResource("Textures/saturnmap.jpg"))).getTexture();
		saturnTexture.setBoundaryModeS(Texture.WRAP);
		saturnTexture.setBoundaryModeT(Texture.WRAP);
		saturnApp.setTexture(saturnTexture);
		saturnApp.setTextureAttributes(texAttr);
		saturn.setAppearance(saturnApp);

		// Uranus Appearance
		Appearance uranusApp = new Appearance();
		Sphere uranus = new Sphere(1.3f, primflags, 100, uranusApp);
		Texture uranusTexture = new TextureLoader(ImageIO.read(getClass().getResource("Textures/uranusmap.jpg"))).getTexture();
		uranusTexture.setBoundaryModeS(Texture.WRAP);
		uranusTexture.setBoundaryModeT(Texture.WRAP);
		uranusApp.setTexture(uranusTexture);
		uranusApp.setTextureAttributes(texAttr);
		uranus.setAppearance(uranusApp);

		// Neptune Appearance
		Appearance neptuneApp = new Appearance();
		Sphere neptune = new Sphere(1.1f, primflags, 100, neptuneApp);
		Texture neptuneTexture = new TextureLoader(ImageIO.read(getClass().getResource("Textures/neptunemap.jpg"))).getTexture();
		neptuneTexture.setBoundaryModeS(Texture.WRAP);
		neptuneTexture.setBoundaryModeT(Texture.WRAP);
		neptuneApp.setTexture(neptuneTexture);
		neptuneApp.setTextureAttributes(texAttr);
		neptune.setAppearance(neptuneApp);
		
		TGA.addChild(allsparkRotGroup);
		allsparkRotGroup.addChild(allsparkGroup);
		allsparkGroup.addChild(allspark);
		
		TGA.addChild(sunGroup);
		sunGroup.addChild(sun);

		TGA.addChild(mercuryRotGroup);
		mercuryRotGroup.addChild(mercuryTranGroup);
		mercuryTranGroup.addChild(mercuryRotGroup2);
		mercuryRotGroup2.addChild(mercury);

		TGA.addChild(venusRotGroup);
		venusRotGroup.addChild(venusTranGroup);
		venusTranGroup.addChild(venusRotGroup2);
		venusRotGroup2.addChild(venus);

		TGA.addChild(earthRotGroup);
		earthRotGroup.addChild(earthTranGroup);
		earthTranGroup.addChild(earthRotGroup2);
		earthRotGroup2.addChild(earth);

		TGA.addChild(marsRotGroup);
		marsRotGroup.addChild(marsTranGroup);
		marsTranGroup.addChild(marsRotGroup2);
		marsRotGroup2.addChild(mars);

		TGA.addChild(jupiterRotGroup);
		jupiterRotGroup.addChild(jupiterTranGroup);
		jupiterTranGroup.addChild(jupiterRotGroup2);
		jupiterRotGroup2.addChild(jupiter);

		TGA.addChild(saturnRotGroup);
		saturnRotGroup.addChild(saturnTranGroup);
		saturnTranGroup.addChild(saturnRotGroup2);
		saturnRotGroup2.addChild(saturn);

		TGA.addChild(uranusRotGroup);
		uranusRotGroup.addChild(uranusTranGroup);
		uranusTranGroup.addChild(uranusRotGroup2);
		uranusRotGroup2.addChild(uranus);

		TGA.addChild(neptuneRotGroup);
		neptuneRotGroup.addChild(neptuneTranGroup);
		neptuneTranGroup.addChild(neptuneRotGroup2);
		neptuneRotGroup2.addChild(neptune);

		// Mouse rotate behaviour
		MouseRotate mouseRotate = new MouseRotate();
		mouseRotate.setTransformGroup(mainTG);
		objRoot.addChild(mouseRotate);
		mouseRotate.setSchedulingBounds(bounds);

		// Mouse zoom behaviour
		MouseZoom mouseZoom = new MouseZoom();
		mouseZoom.setTransformGroup(mainTG);
		objRoot.addChild(mouseZoom);	
		mouseZoom.setSchedulingBounds(bounds);

		// Mouse translate behaviour
		MouseTranslate mouseTranslate = new MouseTranslate();
		mouseTranslate.setTransformGroup(mainTG);
		objRoot.addChild(mouseTranslate);
		mouseTranslate.setSchedulingBounds(bounds);

		objRoot.compile();
		return objRoot;
	}

	public SolarSystem() throws IOException {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		Canvas3D canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration() );
		con.add("Center", canvas);
		BranchGroup scene = createSceneGraph();
		SimpleUniverse universe = new SimpleUniverse(canvas);
		universe.getViewingPlatform().setNominalViewingTransform();
		universe.addBranchGraph(scene);

		// Changes Camera Position
		TransformGroup cameraGroup = universe.getViewingPlatform().getViewPlatformTransform();
		Vector3f cameraTranslate = new Vector3f(); 
		Transform3D T3D = new Transform3D();
		cameraTranslate.set(0f, 5.0f, 150.0f);
		T3D.setTranslation(cameraTranslate);
		cameraGroup.setTransform(T3D);
		universe.getViewer().getView().setBackClipDistance(10000);
		setTitle("Solar System");
		setSize(1500,1000);
		setVisible(true);
	}

	public static void main(String[] args) {        
		try {
			SolarSystem e = new SolarSystem();
		} catch (IOException e) {e.printStackTrace();}
	}
}