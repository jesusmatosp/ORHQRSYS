package pe.gob.onp.orrhh.qr.type;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum DiaType {
	LUNES(2 , "LU"),
	MARTES(3, "MA"),
	MIERCOLES(4, "MIE"),
	JUEVES(5, "JU"),
	VIERNES(6, "VI"),
	SABADO(7, "SAB"),
	DOMINGO(1, "DOM");
	
	/** La key. */
	private Integer key;
	
	/** La value. */
	private String value;

	
	/** La Constante list. */
	private static List<DiaType> list = new ArrayList<DiaType>();
	
	/** La Constante lookup. */
	private static Map<Integer, DiaType> lookup = new HashMap<Integer, DiaType>();

	static {
		for (DiaType s : EnumSet
				.allOf(DiaType.class)) {
			list.add(s);
			lookup.put(s.getKey(), s);
		}
	}

	/**
	 * Instancia un nuevo estado actividad type.
	 *
	 * @param key el key
	 * @param value el value
	 */
	private DiaType(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Obtiene key.
	 *
	 * @return key
	 */
	public Integer getKey() {
		return key;
	}
	
	/**
	 * Obtiene value.
	 *
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Gets the.
	 *
	 * @param key el key
	 * @return the estado actividad type
	 */
	public static DiaType get(Integer key) {
		DiaType temp = lookup.get(key);
		return temp;
	}
}
