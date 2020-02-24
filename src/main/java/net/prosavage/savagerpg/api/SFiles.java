package net.prosavage.savagerpg.api;

import net.prosavage.savagerpg.SavageRPG;
import java.io.File;
import java.util.*;

public class SFiles {

    public int getWeaponAmount(){
        return getWeaponFiles().size();
    }

    public List<File> getWeaponFiles() {
        File[] dir = getWeaponRarityFolders();
        List<File> files = new ArrayList<>();
        for (File file : dir) {
            for (File file1 : file.listFiles()) {
                files.addAll(Collections.singleton(file1));
            }
        }
        return files;
    }

    public List<String> getWeaponFilesName() {
        File[] dir = getWeaponRarityFolders();
        List<String> files = new ArrayList<>();
        for (File file : dir) {
            for (File file1 : file.listFiles()) {
                files.addAll(Collections.singleton(file.getName() + "\\" + file1.getName()));
            }
        }
        return files;
    }

    public List<File[]> getWeaponRarityNames() {
        File[] dir = getWeaponRarityFolders();
        List<File[]> files = new ArrayList<>();
        for (File file : dir) {
            files.addAll(Collections.singleton(file.listFiles()));
        }
        return files;
    }

    public File[] getWeaponRarityFolders(){
        File dir = new File(SavageRPG.getInstance().getWeaponFolder());
        if (dir.listFiles() == null){
            return null;
        }
        return dir.listFiles();
    }

    public int getArmorAmount(){
        return getArmorFiles().size();
    }

    public List<File> getArmorFiles() {
        File[] dir = getArmorRarityFolders();
        List<File> files = new ArrayList<>();
        for (File file : dir) {
            for (File file1 : file.listFiles()) {
                files.addAll(Collections.singleton(file1));
            }
        }
        return files;
    }

    public List<String> getArmorFilesName() {
        File[] dir = getArmorRarityFolders();
        List<String> files = new ArrayList<>();
        for (File file : dir) {
            for (File file1 : file.listFiles()) {
                files.addAll(Collections.singleton(file.getName() + "\\" + file1.getName()));
            }
        }
        return files;
    }

    public List<File[]> getArmorRarityNames() {
        File[] dir = getArmorRarityFolders();
        List<File[]> files = new ArrayList<>();
        for (File file : dir) {
            files.addAll(Collections.singleton(file.listFiles()));
        }
        return files;
    }

    public File[] getArmorRarityFolders(){
        File dir = new File(SavageRPG.getInstance().getArmorFolder());
        if (dir.listFiles() == null){
            return null;
        }
        return dir.listFiles();
    }

    public int getEntityAmount(){
        return getEntityFiles().size();
    }

    public List<File> getEntityFiles() {
        File[] dir = getEntityRarityFolders();
        List<File> files = new ArrayList<>();
        for (File file : dir) {
            for (File file1 : file.listFiles()) {
                files.addAll(Collections.singleton(file1));
            }
        }
        return files;
    }

    public List<String> getEntityFilesName() {
        File[] dir = getEntityRarityFolders();
        List<String> files = new ArrayList<>();
        for (File file : dir) {
            for (File file1 : file.listFiles()) {
                files.addAll(Collections.singleton(file.getName() + "\\" + file1.getName()));
            }
        }
        return files;
    }

    public List<File[]> getEntityRarityNames() {
        File[] dir = getEntityRarityFolders();
        List<File[]> files = new ArrayList<>();
        for (File file : dir) {
            files.addAll(Collections.singleton(file.listFiles()));
        }
        return files;
    }

    public File[] getEntityRarityFolders(){
        File dir = new File(SavageRPG.getInstance().getEntityFolder());
        if (dir.listFiles() == null){
            return null;
        }
        return dir.listFiles();
    }

    public int getAbilityAmount(){
        if (getAbilityFiles() != null) {
            return getAbilityFiles().length;
        }
        return 0;
    }

    public File[] getAbilityFiles(){
        File dir = new File(SavageRPG.getInstance().getAbilityFolder());
        if (dir.listFiles() == null){
            return null;
        }
        return dir.listFiles();
    }

    public List<String> getAbilityNames(){
        File dir = new File(SavageRPG.getInstance().getAbilityFolder());
        List<String> files = new ArrayList<>();
        if (dir.listFiles() == null){
            return null;
        }
        for (File file : dir.listFiles()){
            files.add(file.getName());
        }
        return files;
    }

    public void removeAbilityFiles(){
        File dir = new File(SavageRPG.getInstance().getAbilityFolder());
        for (File file : dir.listFiles()){
            file.delete();
        }
    }

}
