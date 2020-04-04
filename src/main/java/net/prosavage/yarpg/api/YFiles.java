package net.prosavage.yarpg.api;

import net.prosavage.yarpg.YaRPG;
import java.io.File;
import java.util.*;

public class YFiles {

    public int getWeaponAmount(){
        return getWeaponFiles() != null ? getWeaponFiles().size() : 0;
    }

    public List<File> getWeaponFiles() {
        File[] dir = getWeaponRarityFolders();
        List<File> files = new ArrayList<>();
        if (dir != null) {
            for (File file : dir) {
                for (File file1 : file.listFiles()) {
                    files.addAll(Collections.singleton(file1));
                }
            }
            return files;
        }
        return null;
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
        File dir = new File(YaRPG.getInstance().getWeaponFolder());
        if (dir.listFiles() == null){
            return null;
        }
        return dir.listFiles();
    }

    public int getArmorAmount(){
        return getArmorFiles() != null ? getArmorFiles().size() : 0;
    }

    public List<File> getArmorFiles() {
        File[] dir = getArmorRarityFolders();
        List<File> files = new ArrayList<>();
        if (dir != null) {
            for (File file : dir) {
                for (File file1 : file.listFiles()) {
                    files.addAll(Collections.singleton(file1));
                }
            }
            return files;
        }
        return null;
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
        File dir = new File(YaRPG.getInstance().getArmorFolder());
        if (dir.listFiles() == null){
            return null;
        }
        return dir.listFiles();
    }

    public int getEntityAmount(){
        return getEntityFiles() != null ? getEntityFiles().size() : 0;
    }

    public List<File> getEntityFiles() {
        File[] dir = getEntityRarityFolders();
        List<File> files = new ArrayList<>();
        if (dir != null) {
            for (File file : dir) {
                for (File file1 : file.listFiles()) {
                    files.addAll(Collections.singleton(file1));
                }
            }
            return files;
        }
        return null;
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
        File dir = new File(YaRPG.getInstance().getEntityFolder());
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
        File dir = new File(YaRPG.getInstance().getAbilityFolder());
        if (dir.listFiles() == null){
            return null;
        }
        return dir.listFiles();
    }

    public List<String> getAbilityNames(){
        File dir = new File(YaRPG.getInstance().getAbilityFolder());
        List<String> files = new ArrayList<>();
        File[] files1 = dir.listFiles();
        if (files1 != null) {
            for (File file : files1) {
                files.add(file.getName());
            }
            return files;
        }
        return null;
    }

    public void removeAbilityFiles(){
        File dir = new File(YaRPG.getInstance().getAbilityFolder());
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
    }

}
