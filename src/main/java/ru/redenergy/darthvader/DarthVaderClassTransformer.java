package ru.redenergy.darthvader;

import net.minecraft.launchwrapper.IClassTransformer;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DarthVaderClassTransformer implements IClassTransformer {

    private static final String FIXES_EXSTENSION = "mcf";

    private List<File> fixes = identifyFixes(new File("mcfix/"));
    private List<ZipFile> zipFixes = new ArrayList<>();

    public DarthVaderClassTransformer() throws IOException {
        for(File f: fixes){
            zipFixes.add(new ZipFile(f));
        }
    }

    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        try {
            String fileName = name.replace(".", "/") + ".class";
            byte[] replacement = findReplacement(fileName);
            return replacement != null ? replacement : bytes;
        } catch (IOException e) {
            e.printStackTrace();
            return bytes;
        }
    }

    private byte[] findReplacement(String className) throws IOException {
        for(ZipFile z: zipFixes){
            ZipEntry entry = z.getEntry(className);
            if(entry != null){
                return IOUtils.toByteArray(z.getInputStream(entry));
            }
        }
        return null;
    }

    private List<File> identifyFixes(File dir){
        if(!dir.exists()) dir.mkdir();
        List<File> files = new ArrayList<>();
        for(File f: dir.listFiles()){
            if(f.isFile() && FilenameUtils.getExtension(f.getName()).equals(FIXES_EXSTENSION)){
                files.add(f);
            }
        }
        return files;
    }

}
