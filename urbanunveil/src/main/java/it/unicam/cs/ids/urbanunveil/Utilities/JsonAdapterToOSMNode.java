package it.unicam.cs.ids.urbanunveil.Utilities;

import org.json.JSONArray;
import org.json.JSONObject;

import it.unicam.cs.ids.urbanunveil.Entity.OSMNode;

public class JsonAdapterToOSMNode {

	
	public OSMNode JsonToOSMNode (JSONArray o) {
		
		JSONObject obj = o.getJSONObject(0);
		
		OSMNode nodo = new OSMNode(obj.getLong("osm_id"), obj.getDouble("lat"), obj.getDouble("lon"), obj.getString("display_name"));
		return nodo;
		
	}
}
