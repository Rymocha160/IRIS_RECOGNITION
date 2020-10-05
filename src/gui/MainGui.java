package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.KeyPoint;
import config.ImageData;
import imgproc.FeatureDescriptionImage;
import imgproc.FeatureExtractionImage;
import imgproc.FeatureExtractionImage2;
import imgproc.ImageProcesser;
import imgproc.PanoramaImage;

public class MainGui  {
	private JFrame frame;
	private JPanel panel_select_file, panel_select,a,b;
	JLabel label_imgtest,label_img1, label_img2, label_descriptorResult, label_panorama;

	//-----------------------------------------------------------------
	public String[] temp = {"001_1_1.bmp","001_1_2.bmp","001_1_3.bmp","001_2_1.bmp","001_2_2.bmp","001_2_3.bmp","001_2_4.bmp","002_1_1.bmp","002_1_2.bmp","002_1_3.bmp",
			"002_2_1.bmp","002_2_2.bmp", "002_2_3.bmp","002_2_4.bmp","003_1_1.bmp", "003_1_2.bmp","003_1_3.bmp","003_2_1.bmp", "003_2_2.bmp", "003_2_3.bmp","003_2_4.bmp", "004_1_1.bmp","004_1_2.bmp","004_1_3.bmp", "004_2_1.bmp", "004_2_3.bmp", "004_2_4.bmp","005_1_1.bmp", "005_1_2.bmp","005_1_3.bmp", "005_2_1.bmp","005_2_2.bmp","005_2_3.bmp","005_2_4.bmp","006_1_1.bmp","006_1_2.bmp","006_1_3.bmp", "006_2_1.bmp","006_2_2.bmp","006_2_3.bmp", "006_2_4.bmp","007_1_1.bmp","007_1_2.bmp","007_1_3.bmp","007_2_1.bmp","007_2_2.bmp","007_2_3.bmp","007_2_4.bmp","008_1_1.bmp","008_1_2.bmp","008_1_3.bmp","008_2_1.bmp","008_2_2.bmp","008_2_3.bmp","008_2_4.bmp","009_1_1.bmp", "009_1_2.bmp","009_1_3.bmp","009_2_1.bmp","009_2_2.bmp","009_2_3.bmp","009_2_4.bmp","010_1_1.bmp", 
			"010_1_2.bmp","010_1_3.bmp","010_2_1.bmp","010_2_2.bmp","010_2_3.bmp","010_2_4.bmp",
			"011_1_1.bmp","011_1_2.bmp","011_1_3.bmp",

	"012_1_1.bmp","012_1_2.bmp","012_1_3.bmp","012_2_1.bmp","012_2_2.bmp","012_2_3.bmp","012_2_4.bmp",

	"013_1_1.bmp","013_1_2.bmp","013_1_3.bmp","013_2_1.bmp","013_2_2.bmp","013_2_3.bmp","013_2_4.bmp",

	"014_1_1.bmp","014_1_2.bmp","014_1_3.bmp","014_2_1.bmp","014_2_2.bmp","014_2_3.bmp","014_2_4.bmp",

	"015_1_1.bmp","015_1_2.bmp","015_1_3.bmp","015_2_1.bmp","015_2_2.bmp","015_2_3.bmp","015_2_4.bmp",

	"016_1_1.bmp","016_1_2.bmp","016_1_3.bmp","016_2_1.bmp","016_2_2.bmp","016_2_3.bmp","016_2_4.bmp",

	"017_1_1.bmp","017_1_2.bmp","017_1_3.bmp","017_2_1.bmp","017_2_2.bmp","017_2_3.bmp","017_2_4.bmp",

	"018_1_1.bmp","018_1_2.bmp","018_1_3.bmp","018_2_1.bmp","018_2_2.bmp","018_2_3.bmp","018_2_4.bmp",

	"019_1_1.bmp","019_1_2.bmp","019_1_3.bmp","019_2_1.bmp","019_2_2.bmp","019_2_3.bmp","019_2_4.bmp",

	"020_1_1.bmp","020_1_2.bmp","020_1_3.bmp","020_2_1.bmp","020_2_2.bmp","020_2_3.bmp","020_2_4.bmp",

	"021_1_1.bmp","021_1_2.bmp","021_1_3.bmp","021_2_1.bmp","021_2_2.bmp","021_2_3.bmp","021_2_4.bmp",

	"022_1_1.bmp","022_1_2.bmp","022_1_3.bmp","022_2_1.bmp","022_2_2.bmp","022_2_3.bmp","022_2_4.bmp",

	"023_1_1.bmp","023_1_2.bmp","023_1_3.bmp","023_2_1.bmp","023_2_2.bmp","023_2_3.bmp","023_2_4.bmp",

	"024_1_1.bmp","024_1_2.bmp","024_1_3.bmp","024_2_1.bmp","024_2_2.bmp","024_2_3.bmp","024_2_4.bmp",

	"025_1_1.bmp","025_1_2.bmp","025_1_3.bmp","025_2_1.bmp","025_2_2.bmp","025_2_3.bmp","025_2_4.bmp",

	"026_1_1.bmp","026_1_2.bmp","026_1_3.bmp","026_2_1.bmp","026_2_2.bmp","026_2_3.bmp","026_2_4.bmp",

	"027_1_1.bmp","027_1_2.bmp","027_1_3.bmp","027_2_1.bmp","027_2_2.bmp","027_2_3.bmp","027_2_4.bmp",

	"028_1_1.bmp","028_1_2.bmp","028_1_3.bmp","028_2_1.bmp","028_2_2.bmp","028_2_3.bmp","028_2_4.bmp",

	"029_1_1.bmp","029_1_2.bmp","029_1_3.bmp","029_2_1.bmp","029_2_2.bmp","029_2_3.bmp","029_2_4.bmp",

	"030_1_1.bmp","030_1_2.bmp","030_1_3.bmp","030_2_1.bmp","030_2_2.bmp","030_2_3.bmp","030_2_4.bmp",

	"031_1_1.bmp","031_1_2.bmp","031_1_3.bmp","031_2_1.bmp","031_2_2.bmp","031_2_3.bmp","031_2_4.bmp",

	"032_1_1.bmp","032_1_2.bmp","032_1_3.bmp","032_2_1.bmp","032_2_2.bmp","032_2_3.bmp","032_2_4.bmp",

	"033_1_1.bmp","033_1_2.bmp","033_1_3.bmp","033_2_1.bmp","033_2_2.bmp","033_2_3.bmp","033_2_4.bmp",

	"034_1_1.bmp","034_1_2.bmp","034_1_3.bmp","034_2_1.bmp","034_2_2.bmp","034_2_3.bmp","034_2_4.bmp",

	"035_1_1.bmp","035_1_2.bmp","035_1_3.bmp","035_2_1.bmp","035_2_2.bmp","035_2_3.bmp","035_2_4.bmp",

	"036_1_1.bmp","036_1_2.bmp","036_1_3.bmp","036_2_1.bmp","036_2_2.bmp","036_2_3.bmp","036_2_4.bmp",

	"037_1_1.bmp","037_1_2.bmp","037_1_3.bmp","037_2_1.bmp","037_2_2.bmp","037_2_3.bmp","037_2_4.bmp",

	"038_1_1.bmp","038_1_2.bmp","038_1_3.bmp","038_2_1.bmp","038_2_2.bmp","038_2_3.bmp","038_2_4.bmp",

	"039_1_1.bmp","039_1_2.bmp","039_1_3.bmp","039_2_1.bmp","039_2_2.bmp","039_2_3.bmp","039_2_4.bmp",

	"040_1_1.bmp","040_1_2.bmp","040_1_3.bmp","040_2_1.bmp","040_2_2.bmp","040_2_3.bmp","040_2_4.bmp",

	"041_1_1.bmp","041_1_2.bmp","041_1_3.bmp","041_2_1.bmp","041_2_2.bmp","041_2_3.bmp","041_2_4.bmp",

	"042_1_1.bmp","042_1_2.bmp","042_1_3.bmp","042_2_1.bmp","042_2_2.bmp","042_2_3.bmp","042_2_4.bmp",

	"043_1_1.bmp","043_1_2.bmp","043_1_3.bmp","043_2_1.bmp","043_2_2.bmp","043_2_3.bmp","043_2_4.bmp",

	"044_1_1.bmp","044_1_2.bmp","044_1_3.bmp","044_2_1.bmp","044_2_2.bmp","044_2_3.bmp","044_2_4.bmp",

	"045_1_1.bmp","045_1_2.bmp","045_1_3.bmp","045_2_1.bmp","045_2_2.bmp","045_2_3.bmp","045_2_4.bmp",

	"046_1_1.bmp","046_1_2.bmp","046_1_3.bmp","046_2_1.bmp","046_2_2.bmp","046_2_3.bmp","046_2_4.bmp",

	"047_1_1.bmp","047_1_2.bmp","047_1_3.bmp","047_2_1.bmp","047_2_2.bmp","047_2_3.bmp","047_2_4.bmp",

	"048_1_1.bmp","048_1_2.bmp","048_1_3.bmp","048_2_1.bmp","048_2_2.bmp","048_2_3.bmp","048_2_4.bmp",

	"049_1_1.bmp","049_1_2.bmp","049_1_3.bmp","049_2_1.bmp","049_2_2.bmp","049_2_3.bmp","049_2_4.bmp",

	"050_1_1.bmp","050_1_2.bmp","050_1_3.bmp","050_2_1.bmp","050_2_2.bmp","050_2_3.bmp","050_2_4.bmp",

	"051_1_1.bmp","051_1_2.bmp","051_1_3.bmp","051_2_1.bmp","051_2_2.bmp","051_2_3.bmp","051_2_4.bmp",

	"052_1_1.bmp","052_1_2.bmp","052_1_3.bmp","052_2_1.bmp","052_2_2.bmp","052_2_3.bmp","052_2_4.bmp",

	"053_1_1.bmp","053_1_2.bmp","053_1_3.bmp","053_2_1.bmp","053_2_2.bmp","053_2_3.bmp","053_2_4.bmp",

	"054_1_1.bmp","054_1_2.bmp","054_1_3.bmp","054_2_1.bmp","054_2_2.bmp","054_2_3.bmp","054_2_4.bmp",

	"055_1_1.bmp","055_1_2.bmp","055_1_3.bmp","055_2_1.bmp","055_2_2.bmp","055_2_3.bmp","055_2_4.bmp",

	"056_1_1.bmp","056_1_2.bmp","056_1_3.bmp","056_2_1.bmp","056_2_2.bmp","056_2_3.bmp","056_2_4.bmp",

	"057_1_1.bmp","057_1_2.bmp","057_1_3.bmp","057_2_1.bmp","057_2_2.bmp","057_2_3.bmp","057_2_4.bmp",

	"058_1_1.bmp","058_1_2.bmp","058_1_3.bmp","058_2_1.bmp","058_2_2.bmp","058_2_3.bmp","058_2_4.bmp",

	"059_1_1.bmp","059_1_2.bmp","059_1_3.bmp","059_2_1.bmp","059_2_2.bmp","059_2_3.bmp","059_2_4.bmp",

	"060_1_1.bmp","060_1_2.bmp","060_1_3.bmp","060_2_1.bmp","060_2_2.bmp","060_2_3.bmp","060_2_4.bmp",

	"061_1_1.bmp","061_1_2.bmp","061_1_3.bmp","061_2_1.bmp","061_2_2.bmp","061_2_3.bmp","061_2_4.bmp",

	"062_1_1.bmp","062_1_2.bmp","062_1_3.bmp","062_2_1.bmp","062_2_2.bmp","062_2_3.bmp","062_2_4.bmp",

	"063_1_1.bmp","063_1_2.bmp","063_1_3.bmp","063_2_1.bmp","063_2_2.bmp","063_2_3.bmp","063_2_4.bmp",

	"064_1_1.bmp","064_1_2.bmp","064_1_3.bmp","064_2_1.bmp","064_2_2.bmp","064_2_3.bmp","064_2_4.bmp",

	"065_1_1.bmp","065_1_2.bmp","065_1_3.bmp","065_2_1.bmp","065_2_2.bmp","065_2_3.bmp","065_2_4.bmp",

	"066_1_1.bmp","066_1_2.bmp","066_1_3.bmp","066_2_1.bmp","066_2_2.bmp","066_2_3.bmp","066_2_4.bmp",

	"067_1_1.bmp","067_1_2.bmp","067_1_3.bmp","067_2_1.bmp","067_2_2.bmp","067_2_3.bmp","067_2_4.bmp",

	"068_1_1.bmp","068_1_2.bmp","068_1_3.bmp","068_2_1.bmp","068_2_2.bmp","068_2_3.bmp","068_2_4.bmp",

"069_1_1.bmp","069_1_2.bmp","069_1_3.bmp","069_2_1.bmp","069_2_2.bmp","069_2_3.bmp","069_2_4.bmp",

	"070_1_1.bmp","070_1_2.bmp","070_1_3.bmp","070_2_1.bmp","070_2_2.bmp","070_2_3.bmp","070_2_4.bmp",

	"071_1_1.bmp","071_1_2.bmp","071_1_3.bmp","071_2_1.bmp","071_2_2.bmp","071_2_3.bmp","071_2_4.bmp",

	"072_1_1.bmp","072_1_2.bmp","072_1_3.bmp","072_2_1.bmp","072_2_2.bmp","072_2_3.bmp","072_2_4.bmp",

	"073_1_1.bmp","073_1_2.bmp","073_1_3.bmp","073_2_1.bmp","073_2_2.bmp","073_2_3.bmp","073_2_4.bmp",

	"074_1_1.bmp","074_1_2.bmp","074_1_3.bmp","074_2_1.bmp","074_2_2.bmp","074_2_3.bmp","074_2_4.bmp",

	"075_1_1.bmp","075_1_2.bmp","075_1_3.bmp","075_2_1.bmp","075_2_2.bmp","075_2_3.bmp","075_2_4.bmp",

	"076_1_1.bmp","076_1_2.bmp","076_1_3.bmp","076_2_1.bmp","076_2_2.bmp","076_2_3.bmp","076_2_4.bmp",

	"077_1_1.bmp","077_1_2.bmp","077_1_3.bmp","077_2_1.bmp","077_2_2.bmp","077_2_3.bmp","077_2_4.bmp",
	"078_1_1.bmp","078_1_2.bmp","078_1_3.bmp","078_2_1.bmp","078_2_2.bmp","078_2_3.bmp","078_2_4.bmp",

	"079_1_1.bmp","079_1_2.bmp","079_1_3.bmp","079_2_1.bmp","079_2_2.bmp","079_2_3.bmp","079_2_4.bmp",

	"080_1_1.bmp","080_1_2.bmp","080_1_3.bmp","080_2_1.bmp","080_2_2.bmp","080_2_3.bmp","080_2_4.bmp",
	"081_1_1.bmp","081_1_2.bmp","081_1_3.bmp","081_2_1.bmp","081_2_2.bmp","081_2_3.bmp","081_2_4.bmp",
	"082_1_1.bmp","082_1_2.bmp","082_1_3.bmp","082_2_1.bmp","082_2_2.bmp","082_2_3.bmp","082_2_4.bmp",
	"083_1_1.bmp","083_1_2.bmp","083_1_3.bmp","083_2_1.bmp","083_2_2.bmp","083_2_3.bmp","083_2_4.bmp",
	"084_1_1.bmp","084_1_2.bmp","084_1_3.bmp","084_2_1.bmp","084_2_2.bmp","084_2_3.bmp","084_2_4.bmp",
	"085_1_1.bmp","085_1_2.bmp","085_1_3.bmp","085_2_1.bmp","085_2_2.bmp","085_2_3.bmp","085_2_4.bmp",
	"086_1_1.bmp","086_1_2.bmp","086_1_3.bmp","086_2_1.bmp","086_2_2.bmp","086_2_3.bmp","086_2_4.bmp",
	"087_1_1.bmp","087_1_2.bmp","087_1_3.bmp","087_2_1.bmp","087_2_2.bmp","087_2_3.bmp","087_2_4.bmp",
	"088_1_1.bmp","088_1_2.bmp","088_1_3.bmp","088_2_1.bmp","088_2_2.bmp","088_2_3.bmp","088_2_4.bmp",
	"089_1_1.bmp","089_1_2.bmp","089_1_3.bmp","089_2_1.bmp","089_2_2.bmp","089_2_3.bmp","089_2_4.bmp",

	"090_1_1.bmp","090_1_2.bmp","090_1_3.bmp","090_2_1.bmp","090_2_2.bmp","090_2_3.bmp","090_2_4.bmp",
	"091_1_1.bmp","091_1_2.bmp","091_1_3.bmp","091_2_1.bmp","091_2_2.bmp","091_2_3.bmp","091_2_4.bmp",
	"092_1_1.bmp","092_1_2.bmp","092_1_3.bmp","092_2_1.bmp","092_2_2.bmp","092_2_3.bmp","092_2_4.bmp",
	"093_1_1.bmp","093_1_2.bmp","093_1_3.bmp","093_2_1.bmp","093_2_2.bmp","093_2_3.bmp","093_2_4.bmp",
	"094_1_1.bmp","094_1_2.bmp","094_1_3.bmp","094_2_1.bmp","094_2_2.bmp","094_2_3.bmp","094_2_4.bmp",
	"095_1_1.bmp","095_1_2.bmp","095_1_3.bmp","095_2_1.bmp","095_2_2.bmp","095_2_3.bmp","095_2_4.bmp",
	"096_1_1.bmp","096_1_2.bmp","096_1_3.bmp","096_2_1.bmp","096_2_2.bmp","096_2_3.bmp","096_2_4.bmp",
	"097_1_1.bmp","097_1_2.bmp","097_1_3.bmp","097_2_1.bmp","097_2_2.bmp","097_2_3.bmp","097_2_4.bmp",
	"098_1_1.bmp","098_1_2.bmp","098_1_3.bmp","098_2_1.bmp","098_2_2.bmp","098_2_3.bmp","098_2_4.bmp",
	"099_1_1.bmp","099_1_2.bmp","099_1_3.bmp","099_2_1.bmp","099_2_2.bmp","099_2_3.bmp","099_2_4.bmp",

	
	"100_1_1.bmp","100_1_2.bmp","100_1_3.bmp","100_2_1.bmp","100_2_2.bmp","100_2_3.bmp","100_2_4.bmp",
	"101_1_1.bmp","101_1_2.bmp","101_1_3.bmp","101_2_1.bmp","101_2_2.bmp","101_2_3.bmp","101_2_4.bmp",
	"102_1_1.bmp","102_1_2.bmp","102_1_3.bmp","102_2_1.bmp","102_2_2.bmp","102_2_3.bmp","102_2_4.bmp",
	"103_1_1.bmp","103_1_2.bmp","103_1_3.bmp","103_2_1.bmp","103_2_2.bmp","103_2_3.bmp","103_2_4.bmp",
	"104_1_1.bmp","104_1_2.bmp","104_1_3.bmp","104_2_1.bmp","104_2_2.bmp","104_2_3.bmp","104_2_4.bmp",
	"105_1_1.bmp","105_1_2.bmp","105_1_3.bmp","105_2_1.bmp","105_2_2.bmp","105_2_3.bmp","105_2_4.bmp",
	"106_1_1.bmp","106_1_2.bmp","106_1_3.bmp","106_2_1.bmp","106_2_2.bmp","106_2_3.bmp","106_2_4.bmp",
	"107_1_1.bmp","107_1_2.bmp","107_1_3.bmp","107_2_1.bmp","107_2_2.bmp","107_2_3.bmp","107_2_4.bmp",
	"108_1_1.bmp","108_1_2.bmp","108_1_3.bmp","108_2_1.bmp","108_2_2.bmp","108_2_3.bmp","108_2_4.bmp",

		
	};
	public FeatureExtractionImage[]template = new FeatureExtractionImage[temp.length];

	public int[]vec = new int[temp.length];
	public int[]vec1 = new int[temp.length];
	 final ImageIcon icon = new ImageIcon("C:/Users/Administrateur/Downloads/FeatureExtractionApplication/images/icon.png");

	 //------------------------------------------------------------------
	public static void triBulleDecroissant(int tableau[]) {
		int longueur = tableau.length;
		int tampon = 0;
		boolean permut;
 
		do {
			// hypothèse : le tableau est trié
			permut = false;
			for (int i = 0; i < longueur - 1; i++) {
				// Teste si 2 éléments successifs sont dans le bon ordre ou non
				if (tableau[i] < tableau[i + 1]) {
					// s'ils ne le sont pas, on échange leurs positions
					tampon = tableau[i];
					tableau[i] = tableau[i + 1];
					tableau[i + 1] = tampon;
					permut = true;
				}
			}
		} while (permut);
	}
	//----------------------------------------------------------------

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();

					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGui() {
		initialize();
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//pour l'icon
		ImageIcon img = new ImageIcon("C:/Users/Administrateur/Downloads/FeatureExtractionApplication/images/eye.png");
		frame.setIconImage(img.getImage()); //.getScaledInstance(15, 15, Image.SCALE_DEFAULT)
		//frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 800, 550);
		 frame.setTitle("IRIS RECOGNITION-PROJET IHM");   

	     frame.setLocationRelativeTo(null); 
	// frame.setSize(frame.getToolkit().getScreenSize()); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		
		//pour la 1er page
		JPanel iris = new JPanel();
		iris.add(new TestImagePanel(new ImageIcon("C:\\Users\\Administrateur\\Downloads\\FeatureExtractionApplication\\src\\gui\\mmm.jpg").getImage()));
		//iris.setText("Label Text");
		
		tabbedPane.addTab("Iris", null, iris, null);
		tabbedPane.setBackgroundAt(0, Color.pink);
		//iris.setLayout(new BorderLayout(0, 0));
		
		

		JPanel panel_main = new JPanel();
		a=new JPanel();
		a.setBackground(new Color(119, 136, 153));


		panel_main.add(a, BorderLayout.EAST);
		b=new JPanel();
		b.setBackground(new Color(119, 136, 153));	
		panel_main.add(b, BorderLayout.WEST);
		
		tabbedPane.addTab("Principale", null, panel_main, null);
		tabbedPane.setBackgroundAt(1, Color.lightGray);
		panel_main.setLayout(new BorderLayout(0, 0));
		 // panel_main.setBackground(new ColorPanel(0, Color.RED));  
		

		panel_select_file = new JPanel();
	    panel_select_file.setBackground(Color.pink);		

		panel_select_file.setSize(new Dimension(0, 100));
		FlowLayout fl_panel_select_file = (FlowLayout) panel_select_file.getLayout();
		panel_main.add(panel_select_file, BorderLayout.NORTH);

		JPanel panel_images = new JPanel();
	    panel_images.setBackground(Color.lightGray);		

		panel_main.add(panel_images, BorderLayout.CENTER);

		panel_images.setLayout(new GridLayout(0, 2, 0, 0));

		label_img1 = new JLabel(" ");
		label_img1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ImageData.feaExtImg1 != null && ImageData.feaExtImg2 != null) {
					StringBuilder sb = new StringBuilder();
					for (KeyPoint pt : ImageData.feaExtImg1.getKeyPoints().toArray()) {
						sb.append(pt + "\r\n");
					}
					showDialog(sb.toString());
				}
			}
		});
		label_img1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_images.add(label_img1);

		label_img2 = new JLabel("");
		label_img2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ImageData.feaExtImg1 != null && ImageData.feaExtImg2 != null) {
					StringBuilder sb = new StringBuilder();
					for (KeyPoint pt : ImageData.feaExtImg2.getKeyPoints().toArray()) {
						sb.append(pt + "\r\n");
					}
					showDialog(sb.toString());
				}
			}
		});
		label_img2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_images.add(label_img2);

		JPanel panel = new JPanel();
	    panel.setBackground(Color.pink);		

		panel_main.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton button = new JButton("Image originale");
		button.setFont(new Font("Algerian", Font.BOLD, 18));
		button.setBackground(new Color(255, 182, 193));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showImage(ImageData.img1, label_img1);
				showImage(ImageData.img2, label_img2);
			}
		});
		panel.add(button);

		JButton button_1 = new JButton("1.Extraire les points");
		button_1.setFont(new Font("Algerian", Font.BOLD, 18));
		button_1.setBackground(new Color(255, 182, 193));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ImageData.img1 == null || ImageData.img2 == null) {
					JOptionPane.showMessageDialog(frame, "Entrer l'image d'abord!!");
					return;
				}

				// Feature Extraction on image
				//ImageData.feaExtImgtest = new FeatureExtractionImage2(ImageData.imgtest.getAbsolutePath());

				ImageData.feaExtImg1 = new FeatureExtractionImage2(ImageData.img1.getAbsolutePath());
				ImageData.feaExtImg2 = new FeatureExtractionImage2(ImageData.img2.getAbsolutePath());

				// Show Image with KeyPoints
				//showImage(ImageData.feaExtImgtest.getBufferedImageKeypoints(), label_imgtest);

				showImage(ImageData.feaExtImg1.getBufferedImageKeypoints(), label_img1);
				showImage(ImageData.feaExtImg2.getBufferedImageKeypoints(), label_img2);
			}
		});
		panel.add(button_1);

		JButton btnDescribeFeature = new JButton("2. Description de SIFT");
		btnDescribeFeature.setFont(new Font("Algerian", Font.BOLD, 18));
		btnDescribeFeature.setBackground(new Color(255, 182, 193));
		btnDescribeFeature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ImageData.feaExtImg1 == null || ImageData.feaExtImg2 == null) {
					JOptionPane.showMessageDialog(frame, "Extraire les points d'abord!!");
					return;
				}
				ImageData.feaDesImg = new FeatureDescriptionImage(ImageData.feaExtImg1, ImageData.feaExtImg2);
				showImage(ImageData.feaDesImg.getBufferedImgMatches(), label_descriptorResult);
				tabbedPane.setSelectedIndex(1);
			}
		});
		panel.add(btnDescribeFeature);

		JButton btnPanorama = new JButton("3. SIFT");
		btnPanorama.setFont(new Font("Algerian", Font.BOLD, 18));
		btnPanorama.setBackground(new Color(255, 182, 193));
		btnPanorama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ImageData.feaDesImg == null ) {
					JOptionPane.showMessageDialog(frame, "Extraire SIFT d'abord!!");
					return;
				}
				
				PanoramaImage img = new PanoramaImage(ImageData.feaExtImg1, ImageData.feaExtImg2, ImageData.feaDesImg);
				showImage(img.getBufferedPanoramaImage(), label_panorama);
				tabbedPane.setSelectedIndex(2);
			//	JOptionPane.showMessageDialog(btnPanorama,((MatOfKeyPoint) imgproc.FeatureExtractionImage.goodMatches).toArray().length, "similitude", 0);

				//goodMatches.toArray().length
			}
		});
		panel.add(btnPanorama);

		JPanel panel_descriptor = new JPanel();
	    panel_descriptor.setBackground(Color.pink);		

		tabbedPane.addTab("SIFT", null, panel_descriptor, null);
		
		tabbedPane.setBackgroundAt(2, Color.pink);
		panel_descriptor.setLayout(new BorderLayout(0, 0));

		label_descriptorResult = new JLabel("");
		panel_descriptor.add(label_descriptorResult);

		//_____________________________________________________________
		
		JPanel test = new JPanel();

		tabbedPane.addTab("Test", null, test, null);
		tabbedPane.setBackgroundAt(3, Color.pink);
		test.setLayout(new BorderLayout(0, 0));
		

		panel_select = new JPanel();
		//pour l'image de north
		  panel_select.setBackground(new Color(119, 136, 153));		

			panel_select.setSize(new Dimension(0, 100));
		test.add(panel_select, BorderLayout.NORTH);
		
a=new JPanel();
a.setBackground(new Color(119, 136, 153));


test.add(a, BorderLayout.EAST);
b=new JPanel();
b.setBackground(new Color(119, 136, 153));	
test.add(b, BorderLayout.WEST);
		JPanel image = new JPanel();
		   image.setBackground(new Color(245, 245, 245));		

	//image.setSize(new Dimension(800,800));
		test.add(image, BorderLayout.CENTER);

		image.setLayout(new GridLayout(0, 1, 0, 0)); // nbr lignes col espace lognes col

label_imgtest = new JLabel(" ",JLabel.CENTER);
		label_imgtest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if (ImageData.feaExtImgtest!= null ) {
					StringBuilder sb = new StringBuilder();
					for (KeyPoint pt : ( ImageData.feaExtImgtest).getKeyPoints().toArray()) {
						sb.append(pt + "\r\n");
					}
					showDialog(sb.toString());
				}
			}
		});
		label_imgtest.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
	image.add(label_imgtest,JLabel.CENTER);
		
	
	

	JPanel panele = new JPanel();
	//pour le south de btn start
    panele.setBackground(new Color(119, 136, 153));		

	test.add(panele, BorderLayout.SOUTH);
	panele.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	JButton tt_sift = new JButton("ALL Sift");
	tt_sift.setToolTipText("v");
	tt_sift.setFont(new Font("Algerian", Font.BOLD, 18));
	tt_sift.setBackground(new Color(255, 182, 193));
	tt_sift.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//------------------------------------------------------------
			JOptionPane.showMessageDialog(frame, "veuillez attendre quelques minutes s'il vous plaît","IRIS_RECOGNITION", 0, icon);

			//String path = "C:\\Users\\Administrateur\\Videos\\SIFT-master (1)\\";
			for(int i=0;i<temp.length;i++) {
				//String nom=path.concat(template[i]);
				//ImageData.feaExtImgtest = new FeatureExtractionImage("C:\\Users\\Administrateur\\Videos\\SIFT-master (1)\\001_1_1.bmp");
              ImageData.feaExtImgtest = new FeatureExtractionImage2(temp[i]);
          
      			template[i]= ImageData.feaExtImgtest;
      	
       		 }

			/*for(int i=0;i<template.length;i++
					) {
				System.out.println(" "+i+""+template[i]);
			}
			*/
			
			//-------------------------------------------------------------
			

		}});
		panele.add(tt_sift);
		
	

	/*JButton buttone = new JButton("Image originale");
	buttone.setToolTipText("v");

	buttone.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showImage(ImageData.imgtest, label_imgtest);
		
		}
	});
	buttone.setFont(new Font("Algerian", Font.BOLD, 18));
	buttone.setBackground(new Color(255, 182, 193));
	panele.add(buttone);*/
	
	
	
	
	
	/*JButton buttone_1 = new JButton("1-Extraire les points");
	buttone_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (ImageData.imgtest == null ) {
				JOptionPane.showMessageDialog(frame, "Entrer l'image d'abord!!");
				return;
			}

			// Feature Extraction on image
			ImageData.feaExtImgtest = new FeatureExtractionImage2(ImageData.imgtest.getAbsolutePath());

			// Show Image with KeyPoints
			showImage(ImageData.feaExtImgtest.getBufferedImageKeypoints(), label_imgtest);
		}
	});
	panele.add(buttone_1);*/
	
	
	
	JButton btnLoadImag_test = new JButton("Load Image de test");
	btnLoadImag_test.setFont(new Font("Algerian", Font.BOLD, 18));
	btnLoadImag_test.setBackground(new Color(255, 182, 193));
	btnLoadImag_test.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ImageData.imgtest = showFileSelector(e);
			
			showImage(ImageData.imgtest, label_imgtest);
			

		}
	});



	JComboBox comboBoxe = new JComboBox();
	comboBoxe.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent arg0) {

			if (!arg0.getItem().toString().contains("---")) {
				ImageData.imgtest = new File(arg0.getItem().toString().split("/")[0]);
				showImage(ImageData.imgtest, label_imgtest);
				//System.out.println(ImageData.imgtest);
			}
		}
	});
	
	comboBoxe.setModel(new DefaultComboBoxModel(new String[] { "  Selecter", "001_1_1.bmp","001_1_2.bmp","001_1_3.bmp","001_2_1.bmp","001_2_2.bmp","001_2_3.bmp","001_2_4.bmp","002_1_1.bmp","002_1_2.bmp","002_1_3.bmp",
			"002_2_1.bmp","002_2_2.bmp", "002_2_3.bmp","002_2_4.bmp","003_1_1.bmp", "003_1_2.bmp","003_1_3.bmp","003_2_1.bmp", "003_2_2.bmp", "003_2_3.bmp","003_2_4.bmp", "004_1_1.bmp","004_1_2.bmp","004_1_3.bmp", "004_2_1.bmp", "004_2_3.bmp", "004_2_4.bmp","005_1_1.bmp", "005_1_2.bmp","005_1_3.bmp", "005_2_1.bmp","005_2_2.bmp","005_2_3.bmp","005_2_4.bmp","006_1_1.bmp","006_1_2.bmp","006_1_3.bmp", "006_2_1.bmp","006_2_2.bmp","006_2_3.bmp", "006_2_4.bmp","007_1_1.bmp","007_1_2.bmp","007_1_3.bmp","007_2_1.bmp","007_2_2.bmp","007_2_3.bmp","007_2_4.bmp","008_1_1.bmp","008_1_2.bmp","008_1_3.bmp","008_2_1.bmp","008_2_2.bmp","008_2_3.bmp","008_2_4.bmp","009_1_1.bmp", "009_1_2.bmp","009_1_3.bmp","009_2_1.bmp","009_2_2.bmp","009_2_3.bmp","009_2_4.bmp","010_1_1.bmp", 
			"010_1_2.bmp","010_1_3.bmp","010_2_1.bmp","010_2_2.bmp","010_2_3.bmp","010_2_4.bmp",
			"011_1_1.bmp","011_1_2.bmp","011_1_3.bmp",

	"012_1_1.bmp","012_1_2.bmp","012_1_3.bmp","012_2_1.bmp","012_2_2.bmp","012_2_3.bmp","012_2_4.bmp",

	"013_1_1.bmp","013_1_2.bmp","013_1_3.bmp","013_2_1.bmp","013_2_2.bmp","013_2_3.bmp","013_2_4.bmp",

	"014_1_1.bmp","014_1_2.bmp","014_1_3.bmp","014_2_1.bmp","014_2_2.bmp","014_2_3.bmp","014_2_4.bmp",

	"015_1_1.bmp","015_1_2.bmp","015_1_3.bmp","015_2_1.bmp","015_2_2.bmp","015_2_3.bmp","015_2_4.bmp",

	"016_1_1.bmp","016_1_2.bmp","016_1_3.bmp","016_2_1.bmp","016_2_2.bmp","016_2_3.bmp","016_2_4.bmp",

	"017_1_1.bmp","017_1_2.bmp","017_1_3.bmp","017_2_1.bmp","017_2_2.bmp","017_2_3.bmp","017_2_4.bmp",

	"018_1_1.bmp","018_1_2.bmp","018_1_3.bmp","018_2_1.bmp","018_2_2.bmp","018_2_3.bmp","018_2_4.bmp",

	"019_1_1.bmp","019_1_2.bmp","019_1_3.bmp","019_2_1.bmp","019_2_2.bmp","019_2_3.bmp","019_2_4.bmp",

	"020_1_1.bmp","020_1_2.bmp","020_1_3.bmp","020_2_1.bmp","020_2_2.bmp","020_2_3.bmp","020_2_4.bmp",

	"021_1_1.bmp","021_1_2.bmp","021_1_3.bmp","021_2_1.bmp","021_2_2.bmp","021_2_3.bmp","021_2_4.bmp",

	"022_1_1.bmp","022_1_2.bmp","022_1_3.bmp","022_2_1.bmp","022_2_2.bmp","022_2_3.bmp","022_2_4.bmp",

	"023_1_1.bmp","023_1_2.bmp","023_1_3.bmp","023_2_1.bmp","023_2_2.bmp","023_2_3.bmp","023_2_4.bmp",

	"024_1_1.bmp","024_1_2.bmp","024_1_3.bmp","024_2_1.bmp","024_2_2.bmp","024_2_3.bmp","024_2_4.bmp",

	"025_1_1.bmp","025_1_2.bmp","025_1_3.bmp","025_2_1.bmp","025_2_2.bmp","025_2_3.bmp","025_2_4.bmp",

	"026_1_1.bmp","026_1_2.bmp","026_1_3.bmp","026_2_1.bmp","026_2_2.bmp","026_2_3.bmp","026_2_4.bmp",

	"027_1_1.bmp","027_1_2.bmp","027_1_3.bmp","027_2_1.bmp","027_2_2.bmp","027_2_3.bmp","027_2_4.bmp",

	"028_1_1.bmp","028_1_2.bmp","028_1_3.bmp","028_2_1.bmp","028_2_2.bmp","028_2_3.bmp","028_2_4.bmp",

	"029_1_1.bmp","029_1_2.bmp","029_1_3.bmp","029_2_1.bmp","029_2_2.bmp","029_2_3.bmp","029_2_4.bmp",

	"030_1_1.bmp","030_1_2.bmp","030_1_3.bmp","030_2_1.bmp","030_2_2.bmp","030_2_3.bmp","030_2_4.bmp",

	"031_1_1.bmp","031_1_2.bmp","031_1_3.bmp","031_2_1.bmp","031_2_2.bmp","031_2_3.bmp","031_2_4.bmp",

	"032_1_1.bmp","032_1_2.bmp","032_1_3.bmp","032_2_1.bmp","032_2_2.bmp","032_2_3.bmp","032_2_4.bmp",

	"033_1_1.bmp","033_1_2.bmp","033_1_3.bmp","033_2_1.bmp","033_2_2.bmp","033_2_3.bmp","033_2_4.bmp",

	"034_1_1.bmp","034_1_2.bmp","034_1_3.bmp","034_2_1.bmp","034_2_2.bmp","034_2_3.bmp","034_2_4.bmp",

	"035_1_1.bmp","035_1_2.bmp","035_1_3.bmp","035_2_1.bmp","035_2_2.bmp","035_2_3.bmp","035_2_4.bmp",

	"036_1_1.bmp","036_1_2.bmp","036_1_3.bmp","036_2_1.bmp","036_2_2.bmp","036_2_3.bmp","036_2_4.bmp",

	"037_1_1.bmp","037_1_2.bmp","037_1_3.bmp","037_2_1.bmp","037_2_2.bmp","037_2_3.bmp","037_2_4.bmp",

	"038_1_1.bmp","038_1_2.bmp","038_1_3.bmp","038_2_1.bmp","038_2_2.bmp","038_2_3.bmp","038_2_4.bmp",

	"039_1_1.bmp","039_1_2.bmp","039_1_3.bmp","039_2_1.bmp","039_2_2.bmp","039_2_3.bmp","039_2_4.bmp",

	"040_1_1.bmp","040_1_2.bmp","040_1_3.bmp","040_2_1.bmp","040_2_2.bmp","040_2_3.bmp","040_2_4.bmp",

	"041_1_1.bmp","041_1_2.bmp","041_1_3.bmp","041_2_1.bmp","041_2_2.bmp","041_2_3.bmp","041_2_4.bmp",

	"042_1_1.bmp","042_1_2.bmp","042_1_3.bmp","042_2_1.bmp","042_2_2.bmp","042_2_3.bmp","042_2_4.bmp",

	"043_1_1.bmp","043_1_2.bmp","043_1_3.bmp","043_2_1.bmp","043_2_2.bmp","043_2_3.bmp","043_2_4.bmp",

	"044_1_1.bmp","044_1_2.bmp","044_1_3.bmp","044_2_1.bmp","044_2_2.bmp","044_2_3.bmp","044_2_4.bmp",

	"045_1_1.bmp","045_1_2.bmp","045_1_3.bmp","045_2_1.bmp","045_2_2.bmp","045_2_3.bmp","045_2_4.bmp",

	"046_1_1.bmp","046_1_2.bmp","046_1_3.bmp","046_2_1.bmp","046_2_2.bmp","046_2_3.bmp","046_2_4.bmp",

	"047_1_1.bmp","047_1_2.bmp","047_1_3.bmp","047_2_1.bmp","047_2_2.bmp","047_2_3.bmp","047_2_4.bmp",

	"048_1_1.bmp","048_1_2.bmp","048_1_3.bmp","048_2_1.bmp","048_2_2.bmp","048_2_3.bmp","048_2_4.bmp",

	"049_1_1.bmp","049_1_2.bmp","049_1_3.bmp","049_2_1.bmp","049_2_2.bmp","049_2_3.bmp","049_2_4.bmp",

	"050_1_1.bmp","050_1_2.bmp","050_1_3.bmp","050_2_1.bmp","050_2_2.bmp","050_2_3.bmp","050_2_4.bmp",

	"051_1_1.bmp","051_1_2.bmp","051_1_3.bmp","051_2_1.bmp","051_2_2.bmp","051_2_3.bmp","051_2_4.bmp",

	"052_1_1.bmp","052_1_2.bmp","052_1_3.bmp","052_2_1.bmp","052_2_2.bmp","052_2_3.bmp","052_2_4.bmp",

	"053_1_1.bmp","053_1_2.bmp","053_1_3.bmp","053_2_1.bmp","053_2_2.bmp","053_2_3.bmp","053_2_4.bmp",

	"054_1_1.bmp","054_1_2.bmp","054_1_3.bmp","054_2_1.bmp","054_2_2.bmp","054_2_3.bmp","054_2_4.bmp",

	"055_1_1.bmp","055_1_2.bmp","055_1_3.bmp","055_2_1.bmp","055_2_2.bmp","055_2_3.bmp","055_2_4.bmp",

	"056_1_1.bmp","056_1_2.bmp","056_1_3.bmp","056_2_1.bmp","056_2_2.bmp","056_2_3.bmp","056_2_4.bmp",

	"057_1_1.bmp","057_1_2.bmp","057_1_3.bmp","057_2_1.bmp","057_2_2.bmp","057_2_3.bmp","057_2_4.bmp",

	"058_1_1.bmp","058_1_2.bmp","058_1_3.bmp","058_2_1.bmp","058_2_2.bmp","058_2_3.bmp","058_2_4.bmp",

	"059_1_1.bmp","059_1_2.bmp","059_1_3.bmp","059_2_1.bmp","059_2_2.bmp","059_2_3.bmp","059_2_4.bmp",

	"060_1_1.bmp","060_1_2.bmp","060_1_3.bmp","060_2_1.bmp","060_2_2.bmp","060_2_3.bmp","060_2_4.bmp",

	"061_1_1.bmp","061_1_2.bmp","061_1_3.bmp","061_2_1.bmp","061_2_2.bmp","061_2_3.bmp","061_2_4.bmp",

	"062_1_1.bmp","062_1_2.bmp","062_1_3.bmp","062_2_1.bmp","062_2_2.bmp","062_2_3.bmp","062_2_4.bmp",

	"063_1_1.bmp","063_1_2.bmp","063_1_3.bmp","063_2_1.bmp","063_2_2.bmp","063_2_3.bmp","063_2_4.bmp",

	"064_1_1.bmp","064_1_2.bmp","064_1_3.bmp","064_2_1.bmp","064_2_2.bmp","064_2_3.bmp","064_2_4.bmp",

	"065_1_1.bmp","065_1_2.bmp","065_1_3.bmp","065_2_1.bmp","065_2_2.bmp","065_2_3.bmp","065_2_4.bmp",

	"066_1_1.bmp","066_1_2.bmp","066_1_3.bmp","066_2_1.bmp","066_2_2.bmp","066_2_3.bmp","066_2_4.bmp",

	"067_1_1.bmp","067_1_2.bmp","067_1_3.bmp","067_2_1.bmp","067_2_2.bmp","067_2_3.bmp","067_2_4.bmp",

	"068_1_1.bmp","068_1_2.bmp","068_1_3.bmp","068_2_1.bmp","068_2_2.bmp","068_2_3.bmp","068_2_4.bmp",

"069_1_1.bmp","069_1_2.bmp","069_1_3.bmp","069_2_1.bmp","069_2_2.bmp","069_2_3.bmp","069_2_4.bmp",

	"070_1_1.bmp","070_1_2.bmp","070_1_3.bmp","070_2_1.bmp","070_2_2.bmp","070_2_3.bmp","070_2_4.bmp",

	"071_1_1.bmp","071_1_2.bmp","071_1_3.bmp","071_2_1.bmp","071_2_2.bmp","071_2_3.bmp","071_2_4.bmp",

	"072_1_1.bmp","072_1_2.bmp","072_1_3.bmp","072_2_1.bmp","072_2_2.bmp","072_2_3.bmp","072_2_4.bmp",

	"073_1_1.bmp","073_1_2.bmp","073_1_3.bmp","073_2_1.bmp","073_2_2.bmp","073_2_3.bmp","073_2_4.bmp",

	"074_1_1.bmp","074_1_2.bmp","074_1_3.bmp","074_2_1.bmp","074_2_2.bmp","074_2_3.bmp","074_2_4.bmp",

	"075_1_1.bmp","075_1_2.bmp","075_1_3.bmp","075_2_1.bmp","075_2_2.bmp","075_2_3.bmp","075_2_4.bmp",

	"076_1_1.bmp","076_1_2.bmp","076_1_3.bmp","076_2_1.bmp","076_2_2.bmp","076_2_3.bmp","076_2_4.bmp",

	"077_1_1.bmp","077_1_2.bmp","077_1_3.bmp","077_2_1.bmp","077_2_2.bmp","077_2_3.bmp","077_2_4.bmp",
	"078_1_1.bmp","078_1_2.bmp","078_1_3.bmp","078_2_1.bmp","078_2_2.bmp","078_2_3.bmp","078_2_4.bmp",

	"079_1_1.bmp","079_1_2.bmp","079_1_3.bmp","079_2_1.bmp","079_2_2.bmp","079_2_3.bmp","079_2_4.bmp",

	"080_1_1.bmp","080_1_2.bmp","080_1_3.bmp","080_2_1.bmp","080_2_2.bmp","080_2_3.bmp","080_2_4.bmp",
	"081_1_1.bmp","081_1_2.bmp","081_1_3.bmp","081_2_1.bmp","081_2_2.bmp","081_2_3.bmp","081_2_4.bmp",
	"082_1_1.bmp","082_1_2.bmp","082_1_3.bmp","082_2_1.bmp","082_2_2.bmp","082_2_3.bmp","082_2_4.bmp",
	"083_1_1.bmp","083_1_2.bmp","083_1_3.bmp","083_2_1.bmp","083_2_2.bmp","083_2_3.bmp","083_2_4.bmp",
	"084_1_1.bmp","084_1_2.bmp","084_1_3.bmp","084_2_1.bmp","084_2_2.bmp","084_2_3.bmp","084_2_4.bmp",
	"085_1_1.bmp","085_1_2.bmp","085_1_3.bmp","085_2_1.bmp","085_2_2.bmp","085_2_3.bmp","085_2_4.bmp",
	"086_1_1.bmp","086_1_2.bmp","086_1_3.bmp","086_2_1.bmp","086_2_2.bmp","086_2_3.bmp","086_2_4.bmp",
	"087_1_1.bmp","087_1_2.bmp","087_1_3.bmp","087_2_1.bmp","087_2_2.bmp","087_2_3.bmp","087_2_4.bmp",
	"088_1_1.bmp","088_1_2.bmp","088_1_3.bmp","088_2_1.bmp","088_2_2.bmp","088_2_3.bmp","088_2_4.bmp",
	"089_1_1.bmp","089_1_2.bmp","089_1_3.bmp","089_2_1.bmp","089_2_2.bmp","089_2_3.bmp","089_2_4.bmp",

	"090_1_1.bmp","090_1_2.bmp","090_1_3.bmp","090_2_1.bmp","090_2_2.bmp","090_2_3.bmp","090_2_4.bmp",
	"091_1_1.bmp","091_1_2.bmp","091_1_3.bmp","091_2_1.bmp","091_2_2.bmp","091_2_3.bmp","091_2_4.bmp",
	"092_1_1.bmp","092_1_2.bmp","092_1_3.bmp","092_2_1.bmp","092_2_2.bmp","092_2_3.bmp","092_2_4.bmp",
	"093_1_1.bmp","093_1_2.bmp","093_1_3.bmp","093_2_1.bmp","093_2_2.bmp","093_2_3.bmp","093_2_4.bmp",
	"094_1_1.bmp","094_1_2.bmp","094_1_3.bmp","094_2_1.bmp","094_2_2.bmp","094_2_3.bmp","094_2_4.bmp",
	"095_1_1.bmp","095_1_2.bmp","095_1_3.bmp","095_2_1.bmp","095_2_2.bmp","095_2_3.bmp","095_2_4.bmp",
	"096_1_1.bmp","096_1_2.bmp","096_1_3.bmp","096_2_1.bmp","096_2_2.bmp","096_2_3.bmp","096_2_4.bmp",
	"097_1_1.bmp","097_1_2.bmp","097_1_3.bmp","097_2_1.bmp","097_2_2.bmp","097_2_3.bmp","097_2_4.bmp",
	"098_1_1.bmp","098_1_2.bmp","098_1_3.bmp","098_2_1.bmp","098_2_2.bmp","098_2_3.bmp","098_2_4.bmp",
	"099_1_1.bmp","099_1_2.bmp","099_1_3.bmp","099_2_1.bmp","099_2_2.bmp","099_2_3.bmp","099_2_4.bmp",

	
	"100_1_1.bmp","100_1_2.bmp","100_1_3.bmp","100_2_1.bmp","100_2_2.bmp","100_2_3.bmp","100_2_4.bmp",
	"101_1_1.bmp","101_1_2.bmp","101_1_3.bmp","101_2_1.bmp","101_2_2.bmp","101_2_3.bmp","101_2_4.bmp",
	"102_1_1.bmp","102_1_2.bmp","102_1_3.bmp","102_2_1.bmp","102_2_2.bmp","102_2_3.bmp","102_2_4.bmp",
	"103_1_1.bmp","103_1_2.bmp","103_1_3.bmp","103_2_1.bmp","103_2_2.bmp","103_2_3.bmp","103_2_4.bmp",
	"104_1_1.bmp","104_1_2.bmp","104_1_3.bmp","104_2_1.bmp","104_2_2.bmp","104_2_3.bmp","104_2_4.bmp",
	"105_1_1.bmp","105_1_2.bmp","105_1_3.bmp","105_2_1.bmp","105_2_2.bmp","105_2_3.bmp","105_2_4.bmp",
	"106_1_1.bmp","106_1_2.bmp","106_1_3.bmp","106_2_1.bmp","106_2_2.bmp","106_2_3.bmp","106_2_4.bmp",
	"107_1_1.bmp","107_1_2.bmp","107_1_3.bmp","107_2_1.bmp","107_2_2.bmp","107_2_3.bmp","107_2_4.bmp",
	"108_1_1.bmp","108_1_2.bmp","108_1_3.bmp","108_2_1.bmp","108_2_2.bmp","108_2_3.bmp","108_2_4.bmp",





	}));	
	
	
			
	comboBoxe.setToolTipText("");
	comboBoxe.setFont(new Font("Algerian", Font.BOLD, 18));
	comboBoxe.setBackground(new Color(255, 182, 193));
panel_select.add(comboBoxe);
	panel_select.add(btnLoadImag_test);
	
	
	// le plus important dans l'appliction

	JButton recognition = new JButton("START RECOGNITION");
	recognition.setFont(new Font("Algerian", Font.BOLD, 18));
	recognition.setBackground(new Color(255, 182, 193));
	recognition.setToolTipText("v");

	recognition.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if (ImageData.imgtest == null ) {
				JOptionPane.showMessageDialog(frame, "Entrer l'image d'abord!!","ERROR", 0, icon);
				return;
			}
			if (template[0] == null ) {
				JOptionPane.showMessageDialog(frame, "Extraire ALL SIFT d'abord!","ERROR",0,icon);
				return;
			}
			// Feature Extraction on image
			JOptionPane.showMessageDialog(frame, "veuillez attendre quelques minutes s'il vous plaît","IRIS_RECOGNITION", 0, icon);

			ImageData.feaExtImgtest = new FeatureExtractionImage2(ImageData.imgtest.getAbsolutePath());
			ImageData.feaDesImg = new FeatureDescriptionImage(ImageData.feaExtImgtest, ImageData.feaExtImgtest);
            int des=FeatureDescriptionImage.goodMatches.toArray().length;
System.out.println(des);

			// Show Image with KeyPoints
			showImage(ImageData.feaExtImgtest.getBufferedImageKeypoints(), label_imgtest);
			
		for(int i=0;i<vec.length;i++) {
				

				ImageData.feaDesImg = new FeatureDescriptionImage(ImageData.feaExtImgtest, template[i]);
                vec[i]=FeatureDescriptionImage.goodMatches.toArray().length;
                
      		 }
		String rm="";
	for(int i=0;i<vec.length;i++) {
		vec1[i]=(vec[i]*100)/des;
		rm+="L'image"+temp[i]+" "+vec1[i]+"%\n";
	}
	
		triBulleDecroissant(vec);

		/*for(int i=0; i<vec.length;i++) {
			//System.out.println(template[i]);
			System.out.println(vec[i]);

		}*/
		//************************************
		 int somme = 0;
			for(int i=0;i<vec.length;i++) {
				 somme += vec[i];
			}
			 float moy = (float) somme / vec.length;
			 float err=des /moy;
			 
			 
			 double j=(err*100)/des;
			 double k = (double) Math.round(j * 100) / 100; 

	//**********************************************
			
			//JOptionPane.showMessageDialog(frame, "num li ychabholha:\n asemhom: \n ism limage hadi:");
			 if(vec[0]==des) {
				 
				   JOptionPane.showMessageDialog(null, "La personne est reconnue \n L'image la plus identique : "+ImageData.imgtest.getName()+"\nL’erreur de la reconnaissance: "+k+"%\n", "IRIS_RECOGNITION", JOptionPane.INFORMATION_MESSAGE, icon);
					showImage(ImageData.imgtest, label_imgtest);
					TextArea textAre = new TextArea();
					textAre.setText(rm);
					JScrollPane scrollPane = new JScrollPane(textAre);
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

					JOptionPane optionPane = new JOptionPane();
					optionPane.add(scrollPane);

					optionPane.showMessageDialog(null, textAre, "recognition", JOptionPane.INFORMATION_MESSAGE,icon);

				     }
				 else {
				       JOptionPane.showMessageDialog(null,""+ImageData.imgtest.getName()+ " est une personne imposteur \nL’erreur de la reconnaissance: "+k+"%\n", "IRIS_RECOGNITION", JOptionPane.INFORMATION_MESSAGE, icon);
						showImage(ImageData.imgtest, label_imgtest);

			     }
			 
			 
			 /* if(vec[0]==2156) {
			   JOptionPane.showMessageDialog(null, "une personne est reconnue \n\n3 images dans la base\n Les noms des iamges:\n 001_1_1.bmp\n 001_1_2.bmp\n 001_1_3.bmp\n\n image originale:001_1_1.bmp", "IRIS_RECOGNITION", JOptionPane.INFORMATION_MESSAGE, icon);
				showImage(ImageData.imgtest, label_imgtest);

			     }
			 else if(vec[0]==2105){
				   JOptionPane.showMessageDialog(null, "une personne est reconnue \n\n3 images dans la base\n Les noms des iamges:\n 001_1_1.bmp\n 001_1_2.bmp\n 001_1_3.bmp\n\n image originale:001_1_2.bmp", "IRIS_RECOGNITION", JOptionPane.INFORMATION_MESSAGE, icon);
					showImage(ImageData.imgtest, label_imgtest);

			     }
			 else  if(vec[0]==1944) {
				   JOptionPane.showMessageDialog(null, "une personne est reconnue \n\n3 images dans la base\n Les noms des iamges:\n 001_1_1.bmp\n 001_1_2.bmp\n 001_1_3.bmp\n\n image originale:001_1_3.bmp", "IRIS_RECOGNITION", JOptionPane.INFORMATION_MESSAGE, icon);
					showImage(ImageData.imgtest, label_imgtest);

				     }
				 else {
				       JOptionPane.showMessageDialog(null, "personne imposteur ", "IRIS_RECOGNITION", JOptionPane.INFORMATION_MESSAGE, icon);
						showImage(ImageData.imgtest, label_imgtest);

			     }
			 
			/* if(ImageProcesser.n==2156) {
			 // JOptionPane.showMessageDialog(null, ImageProcesser.n, "IRIS_RECOGNITION", JOptionPane.INFORMATION_MESSAGE, icon);
		    	 //+FeatureDescriptionImage.goodMatches.toArray().length

		   JOptionPane.showMessageDialog(null, "une personne est reconnue \n\n3 images dans la base\n Les noms des iamges:\n 001_1_1.bmp\n 001_1_2.bmp\n 001_1_3.bmp\n\n image originale:001_1_1.bmp", "IRIS_RECOGNITION", JOptionPane.INFORMATION_MESSAGE, icon);
			showImage(ImageData.imgtest, label_imgtest);

		     }
		     else  if(ImageProcesser.n==2105) {
			   JOptionPane.showMessageDialog(null, "une personne est reconnue \n\n3 images dans la base\n Les noms des iamges:\n 001_1_1.bmp\n 001_1_2.bmp\n 001_1_3.bmp\n\n image originale:001_1_2.bmp", "IRIS_RECOGNITION", JOptionPane.INFORMATION_MESSAGE, icon);
				showImage(ImageData.imgtest, label_imgtest);

		     }
		     else  if(ImageProcesser.n==1944) {
				   JOptionPane.showMessageDialog(null, "une personne est reconnue \n\n3 images dans la base\n Les noms des iamges:\n 001_1_1.bmp\n 001_1_2.bmp\n 001_1_3.bmp\n\n image originale:001_1_3.bmp", "IRIS_RECOGNITION", JOptionPane.INFORMATION_MESSAGE, icon);
					showImage(ImageData.imgtest, label_imgtest);

				     }
		        //JOptionPane.showMessageDialog(null, "num li ychabholha:\n asemhom: \n ism limage hadi:", "IRIS_RECOGNITION", JOptionPane.INFORMATION_MESSAGE, icon);
		     else {
			       JOptionPane.showMessageDialog(null, "personne imposteur ", "IRIS_RECOGNITION", JOptionPane.INFORMATION_MESSAGE, icon);
					showImage(ImageData.imgtest, label_imgtest);

		     }
		 */
		
		
	
		}});
	
	frame.getContentPane().add(recognition, BorderLayout.SOUTH);

	panele.add(recognition);
	

		
		
	   /*for(int i=0; i<template.length;i++) {
				System.out.println(template[i]);
				System.out.println(vec[i]);

			}*/
		
		
		

		
		
		
		
		//______________________________________________________________

		JButton btnLoadImage_1 = new JButton("Load Image 1");
		btnLoadImage_1.setFont(new Font("Algerian", Font.BOLD, 18));
		btnLoadImage_1.setBackground(new Color(255, 182, 193));
		btnLoadImage_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageData.img1 = showFileSelector(e);
				showImage(ImageData.img1, label_img1);
			}
		});

		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				if (!arg0.getItem().toString().contains("---")) {
					ImageData.img1 = new File(arg0.getItem().toString().split("/")[0]);
					ImageData.img2 = new File(arg0.getItem().toString().split("/")[1]);
					showImage(ImageData.img1, label_img1);
					showImage(ImageData.img2, label_img2);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "---Please Select---", "po1.png/po2.png",
				"chu1.png/chu3.png", "till.png/box.png", "pan1.jpg/pan2.jpg", "OLAV.jpg/OLAV1.jpg", "p1.jpg/p2.jpg" }));
		comboBox.setFont(new Font("Algerian", Font.BOLD, 18));
		comboBox.setBackground(new Color(255, 182, 193));
		comboBox.setToolTipText("");
		panel_select_file.add(comboBox);
		panel_select_file.add(btnLoadImage_1);

		JButton btnLoadImage_2 = new JButton("Load Image 2");
		btnLoadImage_2.setFont(new Font("Algerian", Font.BOLD, 18));
		btnLoadImage_2.setBackground(new Color(255, 182, 193));
		btnLoadImage_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageData.img2 = showFileSelector(e);
				showImage(ImageData.img2, label_img2);
			}
		});
		panel_select_file.add(btnLoadImage_2);
	}

	private File showFileSelector(ActionEvent e) {
		final JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
		int returnVal = fc.showOpenDialog((Component) e.getSource());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile();
		}
		return null;
	}

	private void showImage(File imgFile, JLabel label) {

		if (imgFile == null)
			return;

		try {
			BufferedImage img = ImageIO.read(imgFile);
			showImage(img, label);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showImage(BufferedImage img, JLabel label) {
		float labelRatio = (float) label.getWidth() / label.getHeight();
		float imgRatio = (float) img.getWidth() / img.getHeight();

		if (imgRatio > labelRatio)
			label.setIcon(new ImageIcon(
					img.getScaledInstance(label.getWidth(), (int) (label.getWidth() / imgRatio), Image.SCALE_SMOOTH)));
		else
			label.setIcon(new ImageIcon(img.getScaledInstance((int) (label.getHeight() * imgRatio), label.getHeight(),
					Image.SCALE_SMOOTH)));
	}

	private void showDialog(String message) {
		TextArea textArea = new TextArea();
		textArea.setText(message);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JOptionPane optionPane = new JOptionPane();
		optionPane.add(scrollPane);
		 final ImageIcon icon = new ImageIcon("C:/Users/Administrateur/Downloads/FeatureExtractionApplication/images/icon.png");

		optionPane.showMessageDialog(null, textArea, "KeyPoints", JOptionPane.INFORMATION_MESSAGE,icon);
	}

}
