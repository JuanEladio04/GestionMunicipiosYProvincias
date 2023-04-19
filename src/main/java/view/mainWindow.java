package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MunicipioController;
import controller.ProvinciaController;
import model.Municipio;
import model.Provincia;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class mainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField userInputMunicipioTextField;
	private JTextField municipioNameTextField;
	private JComboBox provinciaChooserComboBox;
	private JComboBox municipioChooserComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow frame = new mainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainWindow() {
		setTitle("Gestión de municipios por provincia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		userInputMunicipioTextField = new JTextField();
		GridBagConstraints gbc_userInputMunicipioTextField = new GridBagConstraints();
		gbc_userInputMunicipioTextField.insets = new Insets(0, 0, 5, 5);
		gbc_userInputMunicipioTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userInputMunicipioTextField.gridx = 0;
		gbc_userInputMunicipioTextField.gridy = 0;
		contentPane.add(userInputMunicipioTextField, gbc_userInputMunicipioTextField);
		userInputMunicipioTextField.setColumns(10);
		
		JButton filterButton = new JButton("Filtrar");
		filterMunicipiosByDescription(filterButton);
		GridBagConstraints gbc_filterButton = new GridBagConstraints();
		gbc_filterButton.insets = new Insets(0, 0, 5, 0);
		gbc_filterButton.gridx = 1;
		gbc_filterButton.gridy = 0;
		contentPane.add(filterButton, gbc_filterButton);
		
		municipioChooserComboBox = new JComboBox();
		GridBagConstraints gbc_municipioChooserComboBox = new GridBagConstraints();
		gbc_municipioChooserComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_municipioChooserComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_municipioChooserComboBox.gridx = 0;
		gbc_municipioChooserComboBox.gridy = 1;
		contentPane.add(municipioChooserComboBox, gbc_municipioChooserComboBox);
		
		JButton selectButton = new JButton("Seleccionar");
		setValuesToUpdateMenu(selectButton);
		GridBagConstraints gbc_selectButton = new GridBagConstraints();
		gbc_selectButton.insets = new Insets(0, 0, 5, 0);
		gbc_selectButton.gridx = 1;
		gbc_selectButton.gridy = 1;
		contentPane.add(selectButton, gbc_selectButton);
		
		JLabel lblNewLabel = new JLabel("Municipio Seleccionado:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del municipio:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		municipioNameTextField = new JTextField();
		GridBagConstraints gbc_municipioNameTextField = new GridBagConstraints();
		gbc_municipioNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_municipioNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_municipioNameTextField.gridx = 1;
		gbc_municipioNameTextField.gridy = 0;
		panel.add(municipioNameTextField, gbc_municipioNameTextField);
		municipioNameTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Provincia del municipio:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		provinciaChooserComboBox = new JComboBox();
		GridBagConstraints gbc_provinciaChooserComboBox = new GridBagConstraints();
		gbc_provinciaChooserComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_provinciaChooserComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_provinciaChooserComboBox.gridx = 1;
		gbc_provinciaChooserComboBox.gridy = 1;
		panel.add(provinciaChooserComboBox, gbc_provinciaChooserComboBox);
		
		JButton saveButton = new JButton("Guardar");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Municipio m = MunicipioController.findByDescription(municipioChooserComboBox.getSelectedItem().toString());
				Provincia p = ProvinciaController.findByName(provinciaChooserComboBox.getSelectedItem().toString());
				MunicipioController.realizeUpdate(m.getNombre(), p.getProvincia(), municipioNameTextField.getText());
			}
		});
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.anchor = GridBagConstraints.EAST;
		gbc_saveButton.gridx = 1;
		gbc_saveButton.gridy = 2;
		panel.add(saveButton, gbc_saveButton);
	}

	/**
	 * @param selectButton
	 */
	private void setValuesToUpdateMenu(JButton selectButton) {
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Provincia> provinciaName = ProvinciaController.findAll();
				municipioNameTextField.setText(municipioChooserComboBox.getSelectedItem().toString());
				
				if(provinciaChooserComboBox != null) {
					provinciaChooserComboBox.removeAllItems();
				}
				for (Provincia provincia : provinciaName) {
					provinciaChooserComboBox.addItem(provincia.getProvincia());
				}
				
				Municipio m = MunicipioController.findByDescription(municipioChooserComboBox.getSelectedItem().toString());
				Provincia p = m.getProvincia();
				provinciaChooserComboBox.setSelectedItem(p.getProvincia());
				
			}
		});
	}

	
	/**
	 * @param filterButton
	 */
	private void filterMunicipiosByDescription(JButton filterButton) {
		filterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Municipio> municipios = MunicipioController.findByLikeDescription(userInputMunicipioTextField.getText());
				setValueToMunicipiosCombo(municipioChooserComboBox, municipios);
			}
		});
	}
	
	
	/**
	 * 
	 * @param combo
	 * @param list
	 */
	private static void setValueToMunicipiosCombo(JComboBox combo, List<Municipio> list) {
		if(combo != null) {
			combo.removeAllItems();
		}
		for (Municipio m : list) {
			combo.addItem(m.getNombre());
		}
		
	}
	

}
