package com.roguedevstudios.uarg.System.Core.Elements;

/********************************
*   Formuli Class               *
*   File Name: Formuli.java     *
*                               *
*   The container for each 		*
*   formula created in 			*
*   Formula.java				*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

// Import Section
import java.util.TreeMap;

/**
 * <p>
 * This class implements IFormuli and constructs formulas for the class formula
 * @author Terry Roberson
 * @since 1.0
 */
public class Formuli {
	private TreeMap<String, Formula> _volumeMap;
	private TreeMap<String, Formula[]> _volumeArrayMap;

	/**
	 * Constructs the initial state if the Formuli container
	 * @since 1.0
	 */
	public Formuli() throws Exception {
		try {
			this._build();
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Initializes the TreeMaps for internal formula storage
	 */
	private void _build() {
		this._volumeMap = new TreeMap<String, Formula>();
		this._volumeArrayMap = new TreeMap<String, Formula[]>();
	}
	
	/**
	 * _setVolumeArrayMap method
	 * puts the specified formula with its specified key in the map
	 * @since 1.0
	 */
	private void _setVolumeArrayMap(String key, Formula[] formula) {
		this._volumeArrayMap.put(key, formula);
	}
	
	/**
	 * _setVolumeMap method
	 * puts the specified formula with its specified key in the map
	 * @since 1.0
	 */
	private void _setVolumeMap(String key, Formula formula) {
		this._volumeMap.put(key, formula);
	}
	
	/**
	 * Gets the id for _volumeArrayMap
	 * @param id	the ID associated with the map
	 * @return id
	 * @since 1.0
	 */
	public Formula[] GetVolumeArray(String id) {
		return this._volumeArrayMap.get(id);
	}
	
	/**
	 * Gets the id for _volumeMap
	 * @param id	the ID associated with the map
	 * @return id
	 * @since 1.0
	 */
	public Formula GetVolume(String id) {
		return this._volumeMap.get(id);
	}
	
}


