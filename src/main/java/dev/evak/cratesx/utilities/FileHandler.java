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

package dev.evak.cratesx.utilities;

import dev.evak.cratesx.CratesX;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {

    private Map<String, IFile> fileMap;

    public FileHandler() {
        fileMap = new HashMap<>();
    }

    public void loadFiles() {
        if (new File(CratesX.getInstance().getDataFolder() + File.separator + "crates").exists()) {
            for (File file : new File(CratesX.getInstance().getDataFolder() + File.separator + "crates").listFiles()) {
                fileMap.put(file.getName().replace(".yml", ""), new IFile(file, YamlConfiguration.loadConfiguration(file)));
            }
        }
    }

    public IFile get(String name) {
        return fileMap.get(name);
    }
}


