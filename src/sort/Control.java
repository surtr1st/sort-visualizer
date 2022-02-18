package sort;

import resource.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class Control extends JPanel {
    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;
    private static final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);
    private JPanel adjustmentPanel, visualPanel;
    private SortPanel sortPanel;
    private JLabel lblAdjustment, lblSelection, lblTimeComplex;
    private JButton btnRandomGeneration, btnStart;
    private JCheckBox chkLineEnable;
    private JSlider sldSpeed;
    private JComboBox cboSortSelection;
    private JTextField txtTimeComplex;
    private ArrayList<ISortRunnable> sortType;
    public Control()
    {
        sortType = new ArrayList<ISortRunnable>();
        frameDesign();
        windowsFeel();
        Event();
        setPreferredSize(SCREEN_SIZE);
        setBackground(Color.WHITE);
    }
    private void frameDesign()
    {
        sortPanel = new SortPanel();
        sortPanel.getPreferredSize();
        sortPanel.setBorder(new LineBorder(new Color(0, 191, 103), 2));
        //Panel
        adjustmentPanel = new JPanel();
        adjustmentPanel.setPreferredSize(new Dimension(400, 700));
        adjustmentPanel.setBorder(new LineBorder(Color.BLACK));
        adjustmentPanel.setBackground(new Color(34, 34, 34));

        visualPanel = new JPanel();
        visualPanel.setPreferredSize(new Dimension(1180, 700));
        visualPanel.setBorder(new LineBorder(Color.BLACK));
        //Label
        lblAdjustment = new JLabel("SPEED ADJUSTMENT");
        lblAdjustment.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdjustment.setFont(new Font("Seoge UI", Font.BOLD, 25));
        lblAdjustment.setForeground(new Color(0, 191, 103));
        lblSelection = new JLabel("SORT SELECTION");
        lblSelection.setHorizontalAlignment(SwingConstants.CENTER);
        lblSelection.setFont(new Font("Seoge UI", Font.BOLD, 25));
        lblSelection.setForeground(new Color(0, 191, 103));
        lblTimeComplex = new JLabel("TIME COMPLEXITY");
        lblTimeComplex.setHorizontalAlignment(SwingConstants.CENTER);
        lblTimeComplex.setFont(new Font("Seoge UI", Font.BOLD, 25));
        lblTimeComplex.setForeground(new Color(0, 191, 103));

        //Checkbox
        chkLineEnable = new JCheckBox("Line Enable");
        chkLineEnable.setSelected(true);
        chkLineEnable.setPreferredSize(new Dimension(50, 50));
        chkLineEnable.setFont(new Font("Seoge UI", Font.BOLD, 25));
        chkLineEnable.setForeground(new Color(0, 191, 103));
        chkLineEnable.setBackground(new Color(34, 34, 34));
        chkLineEnable.setBorder(new LineBorder(new Color(0, 191, 103)));

        //Textbox
        txtTimeComplex = new JTextField();
        txtTimeComplex.setBackground(new Color(34, 34, 34));
        txtTimeComplex.setPreferredSize(new Dimension(350, 100));
        txtTimeComplex.setFont(new Font("Consolas", Font.BOLD, 25));
        txtTimeComplex.setBorder(new LineBorder(new Color(0, 191, 103)));
        txtTimeComplex.setForeground(new Color(0, 191, 103));
        txtTimeComplex.setHorizontalAlignment(SwingConstants.CENTER);
        txtTimeComplex.setEditable(false);

        //Button
        btnRandomGeneration = new JButton("GENERATION");
        btnRandomGeneration.setFont(new Font("Seoge UI", Font.PLAIN, 30));
        btnRandomGeneration.setForeground(new Color(0, 191, 103));
        btnRandomGeneration.setBackground(new Color(34, 34, 34));
        btnStart = new JButton("START");
        btnStart.setFont(new Font("Seoge UI", Font.PLAIN, 30));
        btnStart.setForeground(new Color(0, 191, 103));
        btnStart.setBackground(new Color(34, 34, 34));

        //Slider
        sldSpeed = new JSlider(0,50,15);
        sldSpeed.setPaintTicks(true);
        sldSpeed.setMinorTickSpacing(25);
        sldSpeed.setPaintTrack(true);
        sldSpeed.setMajorTickSpacing(5);
        sldSpeed.setPaintLabels(true);
        sldSpeed.setPreferredSize(new Dimension(350, 100));
        sldSpeed.setForeground(new Color(0, 191, 103));
        sldSpeed.setBackground(new Color(34, 34, 34));
        sldSpeed.setFont(new Font("Seoge UI", Font.PLAIN, 15));
        sldSpeed.setBorder(new EmptyBorder(10,10,10,10));

        String[] sortList = new String[] {
                "Selection Sort",
                "Insertion Sort",
                "Interchange Sort",
                "Bubble Sort",
                "Cocktail Sort",
                "Quick Sort",
                "Heap Sort",
                "Odd-Even Sort",
                "Pancake Sort",
                "Gnome Sort"
        };

        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        cboSortSelection = new JComboBox(sortList);
        cboSortSelection.setRenderer(listRenderer);
        cboSortSelection.setBackground(new Color(34, 34, 34));
        cboSortSelection.setPreferredSize(new Dimension(350, 100));
        cboSortSelection.setFont(new Font("Seoge UI", Font.BOLD, 18));
        cboSortSelection.setBorder(new LineBorder(new Color(0, 191, 103)));
        cboSortSelection.setForeground(new Color(0, 191, 103));

        //Layout
        //1.
        GroupLayout adjustment = new GroupLayout(adjustmentPanel);
        adjustment.setHorizontalGroup(
                adjustment.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(adjustment.createSequentialGroup()
                                .addContainerGap(170, Short.MAX_VALUE)
                                .addComponent(lblAdjustment)
                                .addGap(50, 150, 200))
                        .addComponent(lblAdjustment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(adjustment.createSequentialGroup()
                                .addGap(50, 100, 150)
                                .addComponent(btnRandomGeneration, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(150, Short.MAX_VALUE))
                        .addGroup(adjustment.createSequentialGroup()
                                .addGap(50, 125, 150)
                                .addComponent(chkLineEnable, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(100, Short.MAX_VALUE))
                        .addGroup(adjustment.createSequentialGroup()
                                .addGap(0, 150, 200)
                                .addComponent(sldSpeed, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(150, Short.MAX_VALUE))
                        .addGroup(adjustment.createSequentialGroup()
                                .addContainerGap(170, Short.MAX_VALUE)
                                .addComponent(lblSelection)
                                .addGap(20, 180, 200))
                        .addComponent(lblSelection, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(adjustment.createSequentialGroup()
                                .addGap(0, 150, 250)
                                .addComponent(cboSortSelection, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(150, Short.MAX_VALUE))
                        .addGroup(adjustment.createSequentialGroup()
                                .addContainerGap(170, Short.MAX_VALUE)
                                .addComponent(lblTimeComplex)
                                .addGap(50, 175, 250))
                        .addComponent(lblTimeComplex, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(adjustment.createSequentialGroup()
                                .addGap(0, 150, 350)
                                .addComponent(txtTimeComplex, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(150, Short.MAX_VALUE))
        );
        adjustment.setVerticalGroup(
                adjustment.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(adjustment.createSequentialGroup()
                                .addGap(0, 50, 100)
                                .addComponent(btnRandomGeneration, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 50, 100)
                                .addComponent(chkLineEnable, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(lblAdjustment)
                                .addGap(20, 25, 25)
                                .addComponent(sldSpeed)
                                .addGap(20, 50, 150)
                                .addComponent(lblSelection)
                                .addGap(20, 25, 25)
                                .addComponent(cboSortSelection, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 50, 150)
                                .addComponent(lblTimeComplex)
                                .addGap(20, 25, 25)
                                .addComponent(txtTimeComplex, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //2.
        GroupLayout visual = new GroupLayout(visualPanel);
        visual.setHorizontalGroup(
                visual.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(visual.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sortPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, visual.createSequentialGroup()
                                .addGap(800, 800, 800)
                                .addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(300, Short.MAX_VALUE))
        );
        visual.setVerticalGroup(
                visual.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(visual.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sortPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 50))

        );
        adjustmentPanel.setLayout(adjustment);
        visualPanel.setLayout(visual);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(adjustmentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(visualPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(adjustmentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(visualPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
    private void windowsFeel()
    {
        try {
            String ui = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(ui);
            SwingUtilities.updateComponentTreeUI(this);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    private void Event()
    {
        btnRandomGeneration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortPanel.Generation();
                sortPanel.shuffleElement();
                sortPanel.resetColor();
                if(chkLineEnable.isSelected())
                    sortPanel.setLineEnable(true);
                else
                    sortPanel.setLineEnable(false);
            }
        });
        cboSortSelection.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(cboSortSelection.getSelectedItem() == "Selection Sort") {
                    sortType.clear();
                    sortType.add(new SelectionSort());
                    txtTimeComplex.setText("O(n^2)");
                }
                else if(cboSortSelection.getSelectedItem() == "Interchange Sort") {
                    sortType.clear();
                    sortType.add(new InterchangeSort());
                    txtTimeComplex.setText("O(n^2)");
                }
                else if(cboSortSelection.getSelectedItem() == "Bubble Sort") {
                    sortType.clear();
                    sortType.add(new BubbleSort());
                    txtTimeComplex.setText("O(n^2)");
                }
                else if(cboSortSelection.getSelectedItem() == "Cocktail Sort") {
                    sortType.clear();
                    sortType.add(new ShakerSort());
                    txtTimeComplex.setText("O(n^2)");
                }
                else if(cboSortSelection.getSelectedItem() == "Quick Sort") {
                    sortType.clear();
                    sortType.add(new QuickSort());
                    txtTimeComplex.setText("O(nlogn)");
                }
                else if(cboSortSelection.getSelectedItem() == "Heap Sort") {
                    sortType.clear();
                    sortType.add(new HeapSort());
                    txtTimeComplex.setText("O(nlogn)");
                }
                else if(cboSortSelection.getSelectedItem() == "Odd-Even Sort") {
                    sortType.clear();
                    sortType.add(new OddEvenSort());
                    txtTimeComplex.setText("O(n^2)");
                }
                else if(cboSortSelection.getSelectedItem() == "Pancake Sort") {
                    sortType.clear();
                    sortType.add(new PancakeSort());
                    txtTimeComplex.setText("O(n^2)");
                }
                else {
                    sortType.clear();
                    sortType.add(new GnomeSort());
                    txtTimeComplex.setText("O(n^2)");
                }
            }
        });
        sldSpeed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sortPanel.setSpeed(sldSpeed.getValue());
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortPanel.setStartSorting(true);
                new Thread(() -> {
                    for(ISortRunnable sort : sortType) {
                       try {
                           sortPanel.shuffleElement();
                           sort.startSorting(sortPanel);
                           sortPanel.colorCoverUp();
                           sortPanel.resetColor();
                           Thread.sleep(100);
                       } catch (Exception ex) {
                           break;
                       }
                    }
                }).start();
            }
        });
    }
}
