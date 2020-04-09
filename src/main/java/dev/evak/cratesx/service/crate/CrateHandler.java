/*
 *
 * Eva K. - https://evak.dev/ - CratesX
 *
 * Created on 4/7/20, 12:01 PM
 * Last Modified on 4/7/20, 12:01 PM
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

package dev.evak.cratesx.service.crate;

import dev.evak.cratesx.CratesX;
import dev.evak.cratesx.service.crate.Crate;
import dev.evak.cratesx.utilities.files.FileType;
import dev.evak.cratesx.utilities.files.IFile;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

@Data
public class CrateHandler {

    @Getter(AccessLevel.PRIVATE) private static CratesX instance = CratesX.getInstance();
    @Getter(AccessLevel.PRIVATE) private FileConfiguration mainConf = instance.getFileHandler().getIFile(FileType.CONFIG.getName()).getConfig();

    private Map<Location, Crate> crateMap;
    private Boolean newJoinKeys;
    private Boolean overflowKeys;

    public CrateHandler() {
        crateMap = new HashMap<>();
    }

    public void loadCrates() {
        setNewJoinKeys(false);
        setOverflowKeys(instance.getFileHandler().getIFile(FileType.CONFIG.getName()).getConfig().getBoolean(""));

        for (IFile file : instance.getFileHandler().getFileMap().values()) {
            if(file.getFileName().equals(FileType.CONFIG.getName()) || file.getFileName().equals(FileType.MESSAGES.getName())) continue;
            FileConfiguration config = instance.getFileHandler().getFileMap().get(file.getFileName()).getConfig();
            Crate tempCrate = new Crate(file.getFileNoExtension(), config);
        }
    }

    public void loadLocations() {

    }


}
