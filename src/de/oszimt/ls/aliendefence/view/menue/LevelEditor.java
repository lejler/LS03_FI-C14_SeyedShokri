package de.oszimt.ls.aliendefence.view.menue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import de.oszimt.ls.aliendefence.controller.AlienDefenceController;
import de.oszimt.ls.aliendefence.controller.LevelController;
import de.oszimt.ls.aliendefence.controller.TargetController;
import de.oszimt.ls.aliendefence.model.Level;
import de.oszimt.ls.aliendefence.model.Target;

@SuppressWarnings("serial")
public class LevelEditor extends JPanel {

	private LevelController lvlControl;
	private TargetController targetControl;
	private LeveldesignWindow leveldesignWindow;
	private Level lvl;
	private JTable tblTargets;
	private DefaultTableModel jTableData;
	private JTextField tfdLevelname;
	private JTextField tfdLevel_id;
	private JTextField tfdLevelDuration;
	private JTextField tfdTarget_id;
	private JTextField tfdX;
	private JTextField tfdY;
	private JTextField tfdWidth;
	private JTextField tfdHeight;
	private JTextField tfdStarttime;
	private JTextField tfdTargetDuration;
	private JTextField tfdLevelBackground;
	private JTextField tfdTargetImage;

	/**
	 * Create the frame.
	 */
	public LevelEditor(LeveldesignWindow leveldesignWindow, AlienDefenceController controller,
			Level lvl) {
		this.leveldesignWindow = leveldesignWindow;
		this.lvlControl = controller.getLevelController();
		this.targetControl = controller.getTargetController();
		this.lvl = lvl;

		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout());

		JLabel lblLeveleditor = new JLabel("Leveleditor");
		lblLeveleditor.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeveleditor.setFont(new Font("Arial", Font.BOLD, 18));
		add(lblLeveleditor, BorderLayout.NORTH);

		JPanel pnlMain = new JPanel();
		add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(new GridLayout(0, 2, 20, 0));

		tblTargets = new JTable();
		tblTargets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblTargets.getSelectionModel().addListSelectionListener(new RowListener());
		jTableData = new DefaultTableModel(this.lvl.getTargetsAsTableModel(), Target.getTableDescriptions());
		tblTargets.setModel(jTableData);

		JScrollPane spnTargets = new JScrollPane(tblTargets);
		pnlMain.add(spnTargets);

		JPanel pnlInputs = new JPanel();
		pnlMain.add(pnlInputs);
		pnlInputs.setLayout(new BorderLayout(0, 0));

		JPanel pnlInputMask = new JPanel();
		pnlInputMask.setBackground(SystemColor.activeCaption);
		pnlInputMask.setBorder(new EmptyBorder(10, 5, 10, 5));
		pnlInputs.add(pnlInputMask, BorderLayout.NORTH);
		pnlInputMask.setLayout(new GridLayout(0, 2, 0, 10));

		
		JLabel lblLevelUeberschrift = new JLabel("Level");
		lblLevelUeberschrift.setFont(new Font("Arial", Font.BOLD, 18)); 
		pnlInputMask.add(lblLevelUeberschrift);
		
		JLabel lblLevelUeberschrift2 = new JLabel("");
		pnlInputMask.add(lblLevelUeberschrift2);
		
		JLabel lblLevelid = new JLabel("Level ID");
		pnlInputMask.add(lblLevelid);

		tfdLevel_id = new JTextField(this.lvl.getLevel_id() + "");
		tfdLevel_id.setEditable(false);
		tfdLevel_id.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlInputMask.add(tfdLevel_id);
		tfdLevel_id.setColumns(10);

		JLabel lblLevelname = new JLabel("Name des Level");
		pnlInputMask.add(lblLevelname);

		tfdLevelname = new JTextField(this.lvl.getName());
		tfdLevelname.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlInputMask.add(tfdLevelname);
		tfdLevelname.setColumns(10);

		
		JLabel lblLevelDuration = new JLabel("Spieldauer (Millisekunden)");
		pnlInputMask.add(lblLevelDuration);

		tfdLevelDuration = new JTextField(this.lvl.getDuration() + "");
		tfdLevelDuration.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlInputMask.add(tfdLevelDuration);
		tfdLevelDuration.setColumns(10);

		JButton btnBack = new JButton("zurück zur Levelauswahl");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBack_Clicked(arg0);
			}
		});

		
		JLabel lblbackground = new JLabel("Hintergrundsbild");
		pnlInputMask.add(lblbackground);

		tfdLevelBackground = new JTextField();
		tfdLevelBackground.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlInputMask.add(tfdLevelBackground);
		tfdLevelBackground.setColumns(10);
		pnlInputMask.add(btnBack);

		
		JButton btnSaveLevelChanges = new JButton("\u00C4nderungen am Level speichern");
		btnSaveLevelChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSaveLevelChanges_Clicked(arg0);
			}
		});
		pnlInputMask.add(btnSaveLevelChanges);

		
		JPanel pnlInputMaskTargets = new JPanel();
		pnlInputMaskTargets.setBorder(new EmptyBorder(10, 5, 10, 5));
		pnlInputMaskTargets.setBackground(SystemColor.inactiveCaption);
		pnlInputs.add(pnlInputMaskTargets, BorderLayout.CENTER);
		pnlInputMaskTargets.setLayout(new GridLayout(0, 2, 0, 10));

		
		JLabel lblUeberschrift = new JLabel("Targets");
		lblUeberschrift.setFont(new Font("Arial", Font.BOLD, 18)); 
		pnlInputMaskTargets.add(lblUeberschrift);
		
		JLabel lbllblUeberschrift2 = new JLabel("");
		pnlInputMaskTargets.add(lbllblUeberschrift2);
		
		
		JLabel lblTargetid = new JLabel("Target ID");
		pnlInputMaskTargets.add(lblTargetid);

		tfdTarget_id = new JTextField();
		pnlInputMaskTargets.add(tfdTarget_id);
		tfdTarget_id.setColumns(10);

		tfdTarget_id.setEditable(false);
		
		
		JLabel lblZiel = new JLabel("Ziel:");
		pnlInputMaskTargets.add(lblZiel);
		
		JLabel lblZiel2 = new JLabel("");
		pnlInputMaskTargets.add(lblZiel2);
		
		
		JLabel lblTargetpicture = new JLabel("Bilddatei des Ziels");
		lblTargetpicture.setHorizontalAlignment(SwingConstants.LEFT);
		pnlInputMaskTargets.add(lblTargetpicture);

		tfdTargetImage = new JTextField();
		tfdTargetImage.setHorizontalAlignment(SwingConstants.LEFT);
		pnlInputMaskTargets.add(tfdTargetImage);
		tfdTargetImage.setColumns(10);
			
		
		JLabel lblBreite = new JLabel("Breite des Ziels");
		pnlInputMaskTargets.add(lblBreite);

		tfdWidth = new JTextField();
		pnlInputMaskTargets.add(tfdWidth);
		tfdWidth.setColumns(10);

		
		JLabel lblHhe = new JLabel("Höhe des Ziels");
		pnlInputMaskTargets.add(lblHhe);

		tfdHeight = new JTextField();
		pnlInputMaskTargets.add(tfdHeight);
		tfdHeight.setColumns(10);
		
		
		JLabel lblX = new JLabel("X Position des Ziels (max. 1280 - Breite) ");
		pnlInputMaskTargets.add(lblX);

		tfdX = new JTextField();
		pnlInputMaskTargets.add(tfdX);
		tfdX.setColumns(10);

		
		JLabel lblY = new JLabel("Y Position des Ziels (max. 960 - Höhe)");
		pnlInputMaskTargets.add(lblY);

		tfdY = new JTextField();
		pnlInputMaskTargets.add(tfdY);
		tfdY.setColumns(10);
		
		
		JLabel lblZeiten = new JLabel("Zeiten: ");
		pnlInputMaskTargets.add(lblZeiten);

		JLabel lblZeiten2 = new JLabel(" ");
		pnlInputMaskTargets.add(lblZeiten2);
		
		
		JLabel lblStartzeit = new JLabel("Startzeit in nach Spielstart (Millisekunden)");
		pnlInputMaskTargets.add(lblStartzeit);

		tfdStarttime = new JTextField();
		pnlInputMaskTargets.add(tfdStarttime);
		tfdStarttime.setColumns(10);

		
		JLabel lblAnzeigedauer = new JLabel("Anzeigedauer (Millisekunden)");
		pnlInputMaskTargets.add(lblAnzeigedauer);

		tfdTargetDuration = new JTextField();
		pnlInputMaskTargets.add(tfdTargetDuration);
		tfdTargetDuration.setColumns(10);

		
		JPanel panel_2 = new JPanel();
		pnlInputs.add(panel_2, BorderLayout.SOUTH);

		JButton btnNeuesZiel = new JButton("Neues Ziel");
		btnNeuesZiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnErstellen_Clicked(arg0);
			}
		});
		panel_2.add(btnNeuesZiel);

		JButton btnZielndern = new JButton("Ziel \u00E4ndern");
		btnZielndern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAendern_Clicked(arg0);
			}
		});
		panel_2.add(btnZielndern);

		JButton btnDeleteTarget = new JButton("Ziel l\u00F6schen");
		btnDeleteTarget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLoeschen_Clicked(arg0);
			}
		});
		panel_2.add(btnDeleteTarget);

	}

	public Level getLvl() {
		return lvl;
	}

	public void setLvl(Level lvl) {
		this.lvl = lvl;
		updateTableData();
		this.tfdLevel_id.setText("" + lvl.getLevel_id());
		this.tfdLevelname.setText(lvl.getName());
		this.tfdLevelDuration.setText("" + lvl.getDuration());
		this.tfdLevelBackground.setText(lvl.getBackgroundImage());
	}

	public void updateTableData() {
		jTableData = new DefaultTableModel(this.lvl.getTargetsAsTableModel(), Target.getTableDescriptions());
		tblTargets.setModel(jTableData);
	}

	public void targetAnzeigen_JTable(int row) {
		this.tfdTarget_id.setText((String) tblTargets.getValueAt(row, 0));
		this.tfdX.setText((String) tblTargets.getValueAt(row, 1));
		this.tfdY.setText((String) tblTargets.getValueAt(row, 2));
		this.tfdWidth.setText((String) tblTargets.getValueAt(row, 3));
		this.tfdHeight.setText((String) tblTargets.getValueAt(row, 4));
		this.tfdTargetImage.setText((String) tblTargets.getValueAt(row, 5));
		this.tfdStarttime.setText((String) tblTargets.getValueAt(row, 6));
		this.tfdTargetDuration.setText((String) tblTargets.getValueAt(row, 7));
	}

	public void targetAnzeigen_JTable(Target target) {
		this.tfdTarget_id.setText(target.getTarget_id() + "");
		this.tfdX.setText(target.getHitbox().getX() + "");
		this.tfdY.setText(target.getHitbox().getY() + "");
		this.tfdWidth.setText(target.getHitbox().getWidth() + "");
		this.tfdHeight.setText(target.getHitbox().getHeight() + "");
		this.tfdTargetImage.setText(target.getImageAddress());
		this.tfdStarttime.setText(target.getTime() + "");
		this.tfdTargetDuration.setText(target.getDuration() + "");
	}

	public Target targetAuslesen() {
		Target currentTarget = null;
		for (Target t : this.lvl.getTargets()) {
			if (t.getTarget_id() == Integer.parseInt(tfdTarget_id.getText())) {
				currentTarget = t;
			}
		}
		if (currentTarget != null) {

			currentTarget.getHitbox().setX(Integer.parseInt(tfdX.getText()));
			currentTarget.getHitbox().setY(Integer.parseInt(tfdY.getText()));
			currentTarget.getHitbox().setWidth(Integer.parseInt(tfdWidth.getText()));
			currentTarget.getHitbox().setHeight(Integer.parseInt(tfdHeight.getText()));

			currentTarget.setDuration(Long.parseLong(tfdTargetDuration.getText()));
			currentTarget.setTime(Long.parseLong(tfdStarttime.getText()));
			currentTarget.setImageAddress(tfdTargetImage.getText());
		}
		return currentTarget;
	}

	public void btnErstellen_Clicked(ActionEvent evt) {
		Target target = this.targetControl.createTarget(this.lvl);
		if (target != null)
			targetAnzeigen_JTable(target);
		updateTableData();
	}

	public void btnLoeschen_Clicked(ActionEvent evt) {
		int target_id = Integer.parseInt(this.tfdTarget_id.getText());
		this.targetControl.deleteTarget(this.lvl, target_id);
		updateTableData();
		// TODO clear Textfield-Data
	}

	public void btnAendern_Clicked(ActionEvent evt) {
		this.targetControl.updateTarget(this.lvl, this.targetAuslesen());
		updateTableData();
	}

	/**
	 * Zurück zur Levelauswahl
	 * 
	 * @param evt
	 */
	public void btnBack_Clicked(ActionEvent evt) {
		this.leveldesignWindow.showLevelChooser();
	}

	public void btnSaveLevelChanges_Clicked(ActionEvent evt) {
		this.lvl.setName(this.tfdLevelname.getText());
		this.lvl.setBackgroundImage(this.tfdLevelBackground.getText());
		this.lvl.setDuration(Integer.parseInt(this.tfdLevelDuration.getText()));

		this.lvlControl.updateLevel(this.lvl);
	}

	private class RowListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {
			if (event.getValueIsAdjusting()) {
				return;
			}
			if (tblTargets.getSelectedRow() < 0)
				tblTargets.clearSelection();
			else
				targetAnzeigen_JTable(tblTargets.getSelectedRow());
		}
	}
}
