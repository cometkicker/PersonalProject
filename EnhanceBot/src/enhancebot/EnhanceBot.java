/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enhancebot;

import java.util.Random;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Elijah Badger
 */
public class EnhanceBot {
    
    private String item_name;
    private String item_type;
    private int item_cost;
    private int stone_cost;
    private int frag_cost;
    private int cron_cost;
    private long total_cost;
    private int item_dura;
    private int lvl;
    private int target;
    private int cron_target;
    private int cron_amount;
    private boolean cron_choice;
    private int pri_fail_stack;
    private int duo_fail_stack;
    private int tri_fail_stack;
    private int tet_fail_stack;
    private int pen_fail_stack;
    private int pinned_pri;
    private int pinned_duo;
    private int pinned_tri;
    private int pinned_tet;
    private int pinned_pen;
    
    public EnhanceBot(String item_name, String item_type, int item_cost, int stone_cost, int frag_cost, int cron_cost, int total_cost, int cron_amount, boolean cron_choice, int cron_target, int item_dura, int lvl, int target, int pri_fail_stack,
            int duo_fail_stack, int tri_fail_stack, int tet_fail_stack, int pen_fail_stack) {
        this.item_name = item_name;
        this.item_type = item_type;
        this.item_cost = item_cost;
        this.stone_cost = stone_cost;
        this.frag_cost = frag_cost;
        this.cron_cost = cron_cost;
        this.total_cost = total_cost;
        this.cron_target = cron_target;
        this.cron_choice = cron_choice;
        this.cron_amount = cron_amount;
        this.item_dura = item_dura;
        this.lvl = lvl;
        this.target = target;
        this.pri_fail_stack = pri_fail_stack;
        this.duo_fail_stack = duo_fail_stack;
        this.tri_fail_stack = tri_fail_stack;
        this.tet_fail_stack = tet_fail_stack;
        this.pen_fail_stack = pen_fail_stack;
        this.pinned_pri = pri_fail_stack;
        this.pinned_duo = duo_fail_stack;
        this.pinned_tri = tri_fail_stack;
        this.pinned_tet = tet_fail_stack;
        this.pinned_pen = pen_fail_stack;
    }
    
    public void setName(String new_name) {
        this.item_name = new_name;
    }
    
    public String getName() {
        return this.item_name;
    }
    
    public void setType(String new_type) {
        this.item_type = new_type;
    }
    
    public String getType() {
        return this.item_type;
    }
    
    public void setItemCost(int new_cost) {
        this.item_cost = new_cost;
    }
    
    public int getItemCost() {
        return this.item_cost;
    }
    
    public void setStoneCost(int new_cost) {
        this.stone_cost = new_cost;
    }
    
    public int getStoneCost() {
        return this.stone_cost;
    }
    
    public void setFragCost(int new_cost) {
        this.frag_cost = new_cost;
    }
    
    public int getFragCost() {
        return this.frag_cost;
    }
    
    public void setTotalCost(long new_cost) {
        this.total_cost = new_cost;
    }
    
    public long getTotalCost() {
        return this.total_cost;
    }
    
    public void increaseTotalCost(int x) {
        this.total_cost += x;
    }
    
    public void setItemDura(int new_dura) {
        this.item_dura = new_dura;
        if (this.getItemDura() <= 0) {
            System.out.println("Repairing! Your durability was at " + this.getItemDura());
            this.setTotalCost(new Long((this.getTotalCost() + (this.getFragCost() * 100))));
            this.item_dura = 100;
        }
    }
    
    public int getItemDura() {
        return this.item_dura;
    }
    
    public void setLvl(int new_lvl) {
        this.lvl = new_lvl;
    }
    
    public int getLvl() {
        return this.lvl;
    }
    
    public void setTarget(int new_target) {
        this.target = new_target;
    }
    
    public int getTarget() {
        return this.target;
    }
    
    public void setCronCost(int new_cron) {
        this.cron_cost = new_cron;
    }
    
    public int getCronCost() {
        return this.cron_cost;
    }
    
    public void setCronChoice(boolean new_choice) {
        this.cron_choice = new_choice;
    }

    public boolean getCronChoice() {
        return this.cron_choice;
    }
    
    public void setCronTarget(int new_cTarget) {
        this.cron_target = new_cTarget;
    }
    
    public int getCronTarget() {
        return this.cron_target;
    }
    
    public void setCronAmount(int new_amount) {
        this.cron_amount = new_amount;
    }
    
    public int getCronAmount() {
        return this.cron_amount;
    }
    
    public void setFailstack(int new_stack, int lvl_to_change) {
        if (lvl_to_change == 0) {
            this.pri_fail_stack = new_stack;
        }
        if (lvl_to_change == 1) {
            this.duo_fail_stack = new_stack;
        }
        if (lvl_to_change == 2) {
            this.tri_fail_stack = new_stack;
        }
        if (lvl_to_change == 3) {
            this.tet_fail_stack = new_stack;
        }
        if (lvl_to_change == 4) {
            this.pen_fail_stack = new_stack;
        }
    }
    
    public int getFailstack(int lvl_to_change) {
        int result = 0;
        if (lvl_to_change == 0) {
            result = this.pri_fail_stack;
        }
        if (lvl_to_change == 1) {
            result = this.duo_fail_stack;
        }
        if (lvl_to_change == 2) {
            result = this.tri_fail_stack;
        }
        if (lvl_to_change == 3) {
            result = this.tet_fail_stack;
        }
        if (lvl_to_change == 4) {
            result = this.pen_fail_stack;
        }
        return result;
    }
    
    public void feedback() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String numberAsString = numberFormat.format(this.getTotalCost());
        System.out.println("Run is over! Your " + this.getName() + " cost you " + numberAsString + " in silver.");
    }
    
    public boolean attemptAccessory() {
        boolean test = this.getLvl() == 0;
        boolean flag = false;
        Random r = new Random();
        if (this.getLvl() == 4) {
            double enhance_chance = 0.0050 + (this.getFailstack(4) * 0.0005);
            double pool = 1 - enhance_chance;
            int og_stack = this.pinned_pen;
            double tap = r.nextDouble();
            if (tap >= pool) { //Successful enhancement.
                if (this.getCronChoice() == true && this.getCronTarget() == 4) {
                    this.increaseTotalCost(this.getCronCost() * this.getCronAmount());
                }
                this.setFailstack(og_stack, 4);
                this.setLvl(this.getLvl() + 1);
                System.out.println("Congrats! You just hit PEN!");
                flag = true;
            } else {
                enhance_chance = enhance_chance + (0.0050);
                pool = 1 - enhance_chance;
                this.setFailstack(this.getFailstack(4) + 1, 4);
                this.increaseTotalCost(this.getItemCost() * 6);
                System.out.println("WASTED! You just failed to hit PEN! Current stack size: " + this.getFailstack(this.getLvl()) + ".");
                this.setLvl(0);
                if (this.getCronChoice() == true && this.getCronTarget() == 4) {
                    this.increaseTotalCost(this.getCronCost() * this.getCronAmount());
                    double decay_pool = 0.3333;
                    double decay_chance = r.nextDouble();
                    if (decay_chance <= decay_pool) {
                        System.out.println("You cronned... and succeeded in protecting your accessory!");
                        this.setLvl(4);
                    } else {
                        System.out.println("You cronned... and failed. Decayed by 1 tier.");
                        this.setLvl(3);
                    }
                }
            }
            
        }
        if (this.getLvl() == 3) {
            
            double enhance_chance = 0.0250 + (this.getFailstack(3) * 0.0025);
            double pool = 1 - enhance_chance;
            int og_stack = this.pinned_tet;
            double tap = r.nextDouble();
            if (tap >= pool) {
                this.setFailstack(og_stack, 3);
                this.setLvl(this.getLvl() + 1);
                System.out.println("Congrats! You just hit TET!");
                flag = true;
            } else {
                enhance_chance = enhance_chance + (0.0025);
                pool = 1 - enhance_chance;
                this.setFailstack(this.getFailstack(3) + 1, 3);
                this.increaseTotalCost(this.getItemCost() * 5);
                System.out.println("SO CRUEL! You just failed to hit TET! Current stack size: " + this.getFailstack(this.getLvl()) + ".");
                this.setLvl(0);
            }
        }
        if (this.getLvl() == 2) {
            double enhance_chance = 0.0750 + (this.getFailstack(2) * 0.0075);
            double pool = 1 - enhance_chance;
            int og_stack = this.pinned_tri;
            double tap = r.nextDouble();
            if (tap >= pool) {
                this.setFailstack(og_stack, 2);
                this.setLvl(this.getLvl() + 1);
                System.out.println("Congrats! You just hit TRI!");
                flag = true;
            } else {
                enhance_chance = enhance_chance + (0.0075);
                pool = 1 - enhance_chance;
                this.setFailstack(this.getFailstack(2) + 1, 2);
                this.increaseTotalCost(this.getItemCost() * 4);
                System.out.println("SO CLOSE! You just failed to hit TRI! Current stack size: " + this.getFailstack(this.getLvl()) + ".");
                this.setLvl(0);
            }
        }
        
        if (this.getLvl() == 1) {
            double enhance_chance = 0.1000 + (this.getFailstack(1) * 0.0125);
            double pool = 1 - enhance_chance;
            int og_stack = this.pinned_duo;
            double tap = r.nextDouble();
            if (tap >= pool) {
                this.setFailstack(og_stack, 2);
                this.setLvl(this.getLvl() + 1);
                System.out.println("Congrats! You just hit DUO!");
                flag = true;
            } else {
                enhance_chance = enhance_chance + (0.0125);
                pool = 1 - enhance_chance;
                this.setFailstack(this.getFailstack(1) + 1, 1);
                this.increaseTotalCost(this.getItemCost() * 3);
                System.out.println("THE PAIN! You just failed to hit DUO! Current stack size: " + this.getFailstack(this.getLvl()) + ".");
                this.setLvl(0);
            }
        }
        if (this.getLvl() == 0) {
            double enhance_chance = 0.2500 + (this.getFailstack(0) * 0.0250);
            double pool = 1 - enhance_chance;
            int og_stack = this.pinned_pri;
            double tap = r.nextDouble();
            if (tap >= pool) {
                this.setFailstack(og_stack, 0);
                this.setLvl(this.getLvl() + 1);
                System.out.println("Congrats! You just hit PRI!");
                flag = true;
            } else {
                enhance_chance = enhance_chance + (0.0250);
                pool = 1 - enhance_chance;
                this.setFailstack(this.getFailstack(0) + 1, 0);
                this.increaseTotalCost(this.getItemCost() * 2);
                System.out.println("NOT LIKE THIS! You just failed to hit PRI! Current stack size: " + this.getFailstack(this.getLvl()) + ".");
                this.setLvl(0);
            }
        }
        return flag;
    }
    
    public boolean attemptArmor() {
        boolean flag = false; // As long as this is set to false, nothing has successfully enhanced.
        Random r = new Random();
        if (this.getLvl() == 4) { //TET to PEN attempt
            double enhance_chance = 0.0030 + (this.getFailstack(4) * 0.0003);
            double pool = 1 - enhance_chance;
            int og_stack = this.pinned_pen;
            while (flag == false) {
                double tap = r.nextDouble();
                if (tap >= pool) {
                    this.setFailstack(og_stack, 4);
                    this.setLvl(this.getLvl() + 1);
                    System.out.println("Congrats! You just hit PEN!");
                    flag = true;
                } else {
                    this.setItemDura(this.getItemDura() - 10);
                    enhance_chance = enhance_chance + (0.0003 * 6);
                    pool = 1 - enhance_chance;
                    this.setFailstack(this.getFailstack(4) + 6, 4);
                    this.increaseTotalCost((this.getFragCost() * 10) + (this.getStoneCost()));
                    System.out.println("NOT LIKE THIS! You just failed to hit PEN! Current stack size: " + this.getFailstack(this.getLvl()) + ".");// Enhance chance = " + enhance_chance +".");
                    this.setLvl(this.getLvl() - 1);
                    flag = true;
                }
            }
        }
        if (this.getLvl() == 3) { //TRI to TET attempt
            double enhance_chance = 0.0200 + (this.getFailstack(3) * 0.0020);
            double pool = 1 - enhance_chance;
            int og_stack = this.pinned_tet;
            while (flag == false) {
                double tap = r.nextDouble();
                if (tap >= pool) {
                    this.setFailstack(og_stack, 3);
                    this.setLvl(this.getLvl() + 1);
                    System.out.println("Congrats! You just hit TET! New stack: " + this.getFailstack(3));
                    flag = true;
                } else {
                    this.setItemDura(this.getItemDura() - 10);
                    enhance_chance = enhance_chance + (0.0020 * 5);
                    pool = 1 - enhance_chance;
                    this.setFailstack(this.getFailstack(3) + 5, 3);
                    this.increaseTotalCost((this.getFragCost() * 10) + (this.getStoneCost()));
                    System.out.println("GOD, PLEASE NO! You just failed to hit TET! Current stack size: " + this.getFailstack(this.getLvl()) + ".");// Enhance chance = " + enhance_chance +".");
                    this.setLvl(this.getLvl() - 1);
                    flag = true;
                }
            }
        }
        if (this.getLvl() == 2) { //DUO to TRI attempt
            double enhance_chance = 0.0625 + (this.getFailstack(2) * 0.0063);
            double pool = 1 - enhance_chance;
            int og_stack = this.pinned_tri;
            while (flag == false) {
                double tap = r.nextDouble();
                if (tap >= pool) {
                    flag = true;
                    this.setFailstack(og_stack, 2);
                    this.setLvl(this.getLvl() + 1);
                    System.out.println("Congrats! You just hit TRI! New stack: " + this.getFailstack(2));
                } else {
                    this.setItemDura(this.getItemDura() - 10);
                    if (this.getFailstack(2) <= 102) {
                        enhance_chance = enhance_chance + (0.0063 * 4);
                    } else {
                        enhance_chance = enhance_chance + (0.0012 * 4);
                    }
                    pool = 1 - enhance_chance;
                    this.setFailstack(this.getFailstack(2) + 4, 2);
                    this.increaseTotalCost((this.getFragCost() * 10) + (this.getStoneCost()));
                    System.out.println("SWEET LORD, NO! You just failed to hit TRI! Current stack size: " + this.getFailstack(this.getLvl()) + ".");// Enhance chance = " + enhance_chance +".");
                    this.setLvl(this.getLvl() - 1);
                    flag = true;
                }
            }
        }
        if (this.getLvl() == 1) { //PRI to DUO attempt
            double enhance_chance = 0.0769;
            double pool = 1 - enhance_chance;
            int og_stack = this.getFailstack(this.getLvl());
            while (flag == false) {
                double tap = r.nextDouble();
                if (tap >= pool) {
                    flag = true;
                    this.setFailstack(og_stack, 1);
                    this.setLvl(this.getLvl() + 1);
                    System.out.println("Congrats! You just hit DUO!");
                } else {
                    this.setItemDura(this.getItemDura() - 10);
                    if (this.getFailstack(1) <= 82) {
                        enhance_chance = enhance_chance + (0.0077 * 3);
                    } else {
                        enhance_chance = enhance_chance + (0.0016 * 3);
                    }
                    pool = 1 - enhance_chance;
                    this.setFailstack(this.getFailstack(1) + 3, 1);
                    this.increaseTotalCost((this.getFragCost() * 10) + (this.getStoneCost()));
                    System.out.println("Oof! You just failed to hit DUO! Current stack size: " + this.getFailstack(this.getLvl()) + ".");// Enhance chance = " + enhance_chance +". Tap: " + tap + ". Pool: " + pool);
                }
            }
        }
        if (this.getLvl() == 0) { // +15 to PRI attempt
            double enhance_chance = 0.1176; // used to determine the odds of success.
            double pool = 1 - enhance_chance; // this pool is the numbers that will result in failure. enhance_chance > pool = failure.
            int og_stack = this.getFailstack(this.getLvl());
            while (flag == false) {
                double tap = r.nextDouble();
                if (tap >= pool) {
                    flag = true;
                    this.setFailstack(og_stack, 0);
                    this.setLvl(this.getLvl() + 1);
                    System.out.println("Congrats! You just hit PRI!");
                } else {
                    
                    this.setItemDura(this.getItemDura() - 10);
                    this.increaseTotalCost((this.getFragCost() * 10) + (this.getStoneCost()));
                    if (this.getFailstack(1) <= 50) {
                        enhance_chance = enhance_chance + (0.0117 * 2);
                    } else {
                        enhance_chance = enhance_chance + (0.0023 * 2);
                    }
                    pool = 1 - enhance_chance;
                    this.setFailstack(this.getFailstack(0) + 2, 0);
                    System.out.println("Ouchers! You just failed to hit PRI! Current stack size: " + this.getFailstack(this.getLvl()) + ".");// Enhance chance = " + enhance_chance +".");
                }
            }
        }
        return flag;
    }
    
    public void startSession() {
        if ("armor".equals(this.item_type)) {
            while (this.getLvl() < this.getTarget()) {
                this.attemptArmor();
            }
        }
        if ("accessory".equals(this.item_type)) {
            while (this.getLvl() < this.getTarget()) {
                this.attemptAccessory();
            }
        }
        this.feedback();
        
    }
    
    public void multiSession(int x) {
        int counter = 0;
        while (counter < x) {
            if ("armor".equals(this.item_type)) {
                while (this.getLvl() < this.getTarget()) {
                    counter++;
                    this.attemptArmor();
                }
            }
            if ("accessory".equals(this.item_type)) {
                while (this.getLvl() < this.getTarget()) {
                    counter++;
                    boolean b = this.attemptAccessory();
                    if (b == false){
                        this.setLvl(0);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {

//(String item_name, String item_type, int item_cost, int stone_cost, int frag_cost, int cron_cost, int total_cost, int cron_amount, boolean cron_choice, int cron_target, int item_dura, int lvl, int target, int pri_fail_stack,
        //int duo_fail_stack, int tri_fail_stack, int tet_fail_stack, int pen_fail_stack)
        //EnhanceBot bot = new EnhanceBot("Red Nose Armor", "armor", 47000000, 1130000, 1270000, 0, 100, 0, 5, 15, 30, 40, 70, 110);
        EnhanceBot bot_a = new EnhanceBot("Ogre Ring", "accessory", 120000000, 0, 0, 0, 0, 0, false, 0, 100, 0, 3, 23, 35, 53, 111, 111);
        //bot.startSession();
        bot_a.multiSession(10);
    }
    
}
