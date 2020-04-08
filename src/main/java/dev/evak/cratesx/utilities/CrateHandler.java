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

package dev.evak.cratesx.utilities;

import dev.evak.cratesx.CratesX;
import dev.evak.cratesx.service.crate.Crate;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class CrateHandler {

    private Map<Location, Crate> crateMap;
    private Boolean newJoinKeys;
    private Boolean overflowKeys;
    private CratesX instance = CratesX.getInstance();
    private FileConfiguration mainConf = instance.getFileHandler().getFileMap().get(FileType.CONFIG.getName()).getConfig();

    public CrateHandler() {
        crateMap = new HashMap<>();
    }

    public Map<Location, Crate> getCrateMap() {
        return crateMap;
    }

    public void setCrateMap(Map<Location, Crate> crateMap) {
        this.crateMap = crateMap;
    }

    public CratesX getInstance() {
        return instance;
    }

    public void setInstance(CratesX instance) {
        this.instance = instance;
    }

    public Boolean getNewJoinKeys() {
        return newJoinKeys;
    }

    public void setNewJoinKeys(Boolean newJoinKeys) {
        this.newJoinKeys = newJoinKeys;
    }

    public Boolean getOverflowKeys() {
        return overflowKeys;
    }

    public void setOverflowKeys(Boolean overflowKeys) {
        this.overflowKeys = overflowKeys;
    }

    public void loadLocations() {

    }

    public void loadCrates() {
        FileConfiguration config;
        setNewJoinKeys(false);
        setOverflowKeys(instance.getFileHandler().get(FileType.CONFIG.getName()).getConfig().getBoolean(""));

        Crate tempCrate;
        for (IFile file : instance.getFileHandler().getFileMap().values()) {
            config = instance.getFileHandler().getFileMap().get(file.getFileName()).getConfig();
            //tempCrate = new Crate(config.get);
        }
    }


}
