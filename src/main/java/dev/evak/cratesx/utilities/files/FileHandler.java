/*
 *
 * Eva K. - https://evak.dev/ - CratesX
 *
 * Created on 4/7/20, 12:15 PM
 * Last Modified on 4/7/20, 12:15 PM
 *
 *     Copyright (C) 2020 Eva K.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package dev.evak.cratesx.utilities.files;

import dev.evak.cratesx.CratesX;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.*;

public class FileHandler {

    @Getter(AccessLevel.PRIVATE) private static CratesX instance = CratesX.getInstance();
    
    private Map<String, IFile> fileMap;

    public FileHandler() {
        fileMap = new HashMap<>();
    }

    @SneakyThrows
    public void loadFiles() {
        List<File> folders = new ArrayList<>();
        folders.add(instance.getDataFolder());
        Arrays.stream(instance.getDataFolder().listFiles()).filter(File::isDirectory).forEach(folders::add);

        folders.stream().flatMap(filesInFolders -> Arrays.stream(filesInFolders.listFiles()))
                .filter(ymlFile -> ymlFile.getName().endsWith(".yml"))
                .forEach(file -> {
                    String fileName = file.getName().replace(".yml", "");
                    fileMap.put(fileName, new IFile(file, YamlConfiguration.loadConfiguration(file)));
        });
    }

    public IFile getIFile(String name) {
        return fileMap.get(name);
    }

    public boolean exists(String name) {
        return fileMap.containsKey(name);
    }

    public Map<String, IFile> getFileMap() {
        return new HashMap<>(fileMap);
    }

}


