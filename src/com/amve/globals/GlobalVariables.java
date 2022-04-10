package com.amve.globals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amve.utils.Pair;
import com.amve.utils.Spell;

public abstract class GlobalVariables {
	//TODO: some variables might be in either integer or string format, fix if necessary later
	public static final Integer NORTH_DIR = 0;
	public static final Integer EAST_DIR = 1;
	public static final Integer SOUTH_DIR = 2;
	public static final Integer WEST_DIR = 3;
	public static final Integer UP_DIR = 4;
	public static final Integer DOWN_DIR = 5;

	public static final Integer DOOR_OPEN = 0;
	public static final Integer DOOR_CLOSED = 1;
	public static final Integer DOOR_LOCKED = 2;
	
	public final static Integer DOOR_RESETS_OPENED = 0;
	public final static Integer DOOR_RESETS_CLOSED = 1;
	public final static Integer DOOR_RESETS_LOCKED = 2;
	public final static Integer DOOR_NO_PASSDOOR = 3;
	public final static Integer DOOR_EASY_TO_PICK = 4;
	public final static Integer DOOR_HARD_TO_PICK = 5;
	public final static Integer DOOR_INFURIATING_TO_PICK = 6;
	public final static Integer DOOR_CANNOT_BE_PICKED = 7;
	public final static Integer DOOR_CANNOT_BE_CLOSED = 8;
	public final static Integer DOOR_CANNOT_BE_LOCKED = 9;
		
	public static final Integer LEFT_FINGER = 1;
	public static final Integer RIGHT_FINGER = 2;
	public static final Integer NECK_1 = 3;
	public static final Integer NECK_2 = 4;
	public static final Integer ON_TORSO = 5;
	public static final Integer HEAD = 6;
	public static final Integer LEGS = 7;
	public static final Integer HANDS = 9;
	public static final Integer ARMS = 10;
	public static final Integer SHIELD = 11;
	public static final Integer ABOUT_BODY = 12;
	public static final Integer WAIST = 13;
	public static final Integer LEFT_WRIST = 14;
	public static final Integer RIGHT_WRIST = 15;
	public static final Integer WIELD = 16;
	public static final Integer HELD = 17;
	public static final Integer FLOATING = 18;
	
	public static final Integer LEVEL_MIN = 0;
	public static final Integer LEVEL_MAX = 100;
	
	public static final Map<String, Integer> LETTER_TRANSLATIONS;
	static {
		LETTER_TRANSLATIONS = new HashMap<String, Integer>();
		
		LETTER_TRANSLATIONS.put("A", 1);
		LETTER_TRANSLATIONS.put("B", 2);
		LETTER_TRANSLATIONS.put("C", 4);
		LETTER_TRANSLATIONS.put("D", 8);
		LETTER_TRANSLATIONS.put("E", 16);
		LETTER_TRANSLATIONS.put("F", 32);
		LETTER_TRANSLATIONS.put("G", 64);
		LETTER_TRANSLATIONS.put("H", 128);
		LETTER_TRANSLATIONS.put("I", 256);
		LETTER_TRANSLATIONS.put("J", 512);
		LETTER_TRANSLATIONS.put("K", 1024);
		LETTER_TRANSLATIONS.put("L", 2048);
		LETTER_TRANSLATIONS.put("M", 4096);
		LETTER_TRANSLATIONS.put("N", 8192);
		LETTER_TRANSLATIONS.put("O", 16384);
		LETTER_TRANSLATIONS.put("P", 32768);
		LETTER_TRANSLATIONS.put("Q", 65536);
		LETTER_TRANSLATIONS.put("R", 131072);
		LETTER_TRANSLATIONS.put("S", 262144);
		LETTER_TRANSLATIONS.put("T", 524288);
		LETTER_TRANSLATIONS.put("U", 1048576);
		LETTER_TRANSLATIONS.put("V", 2097152);
		LETTER_TRANSLATIONS.put("W", 4194304);
		LETTER_TRANSLATIONS.put("X", 8388608);
		LETTER_TRANSLATIONS.put("Y", 16777216);
		LETTER_TRANSLATIONS.put("Z", 33554432);
		LETTER_TRANSLATIONS.put("aa", 67108864);
		LETTER_TRANSLATIONS.put("bb", 134217728);
		LETTER_TRANSLATIONS.put("cc", 268435456);
		LETTER_TRANSLATIONS.put("dd", 536870912);
		LETTER_TRANSLATIONS.put("ee", 1073741824);
	}
	
	// Abi bu globallerin hemen hepsini ilerde bu hale getirebiliriz bence
	public enum Position {
		STAND(0, "stand"),
		SIT(1, "sit"),
	    REST(2, "rest"),
	    SLEEP(3, "sleep");
		
		private static final Map<Integer, Position> BY_NUM = new HashMap<>();
		private static final Map<String, Position> BY_NAME = new HashMap<>();
		
		static {
			for (Position e: values()) {
				BY_NUM.put(e.num, e);
				BY_NAME.put(e.name, e);
			}
		}
		
		public final int num;
		public final String name;
		private Position(int num, String name) {
			this.num = num;
			this.name = name;
		}
		
		public static Position valueOfNum(int num) {
			return BY_NUM.get(num);
		}
		public static Position valueOfName(String name) {
			return BY_NAME.get(name);
		}
	}
	
	public static final Integer OBJECT_CONDITION_EXCELLENT = 0;
	public static final Integer OBJECT_CONDITION_GOOD = 1;
	public static final Integer OBJECT_CONDITION_FINE = 2;
	public static final Integer OBJECT_CONDITION_AVERAGE = 3;
	public static final Integer OBJECT_CONDITION_POOR = 4;
	public static final Integer OBJECT_CONDITION_FRAGILE = 5;
	public static final Integer OBJECT_CONDITION_BROKEN = 6;
	
//	public static final String SEX_NONE = "none";
//	public static final String SEX_MALE = "male";
//	public static final String SEX_FEMALE = "female";
//	public static final String SEX_EITHER = "either";
	
	public enum Sex {
		NONE(0, "none"),
		MALE(1, "male"),
	    FEMALE(2, "female"),
	    EITHER(3, "either");
		
		private static final Map<Integer, Sex> BY_NUM = new HashMap<>();
		private static final Map<String, Sex> BY_NAME = new HashMap<>();
		
		static {
			for (Sex e: values()) {
				BY_NUM.put(e.num, e);
				BY_NAME.put(e.name, e);
			}
		}
		
		public final int num;
		public final String name;
		private Sex(int num, String name) {
			this.num = num;
			this.name = name;
		}
		
		public static Sex valueOfNum(int num) {
			return BY_NUM.get(num);
		}
		public static Sex valueOfName(String name) {
			return BY_NAME.get(name);
		}
	}
	
	public static final String POS_DEAD = "dead";
	public static final String POS_MORTAL = "mortal";
	public static final String POS_INCAP = "incap";
	public static final String POS_STUNNED = "stun";
	public static final String POS_SLEEPING = "sleep";
	public static final String POS_RESTING = "rest";
	public static final String POS_SITTING = "sit";
	public static final String POS_FIGHTING = "fight";
	public static final String POS_STANDING = "stand";
	
	public static final String PRACTICER_GROUP_NONE = "group_none";
	public static final String PRACTICER_GROUP_WEAPONS_MASTER = "group_weaponsmaster";
	public static final String PRACTICER_GROUP_ATTACK = "group_attack";
	public static final String PRACTICER_GROUP_BEGUILING = "group_beguiling";
	public static final String PRACTICER_GROUP_BENEDICTIONS = "group_benedictions";
	public static final String PRACTICER_GROUP_COMBAT =	 "group_combat";
	public static final String PRACTICER_GROUP_CREATION = "group_creation";
	public static final String PRACTICER_GROUP_CURATIVE = "group_curative";
	public static final String PRACTICER_GROUP_DEETECTION = "group_detection";
	public static final String PRACTICER_GROUP_DRACONIAN = "group_draconian";
	public static final String PRACTICER_GROUP_ENCHANTMENT = "group_enchantment";
	public static final String PRACTICER_GROUP_ENHANCEMENT = "group_enhancement";
	public static final String PRACTICER_GROUP_HARMFUL = "group_harmful";
	public static final String PRACTICER_GROUP_HEALING = "group_healing";
	public static final String PRACTICER_GROUP_ILLUSION = "group_illusion";
	public static final String PRACTICER_GROUP_MALADICTIONS = "group_maladictions";
	public static final String PRACTICER_GROUP_PROTECTIVE = "group_protective";
	public static final String PRACTICER_GROUP_TRANSPORTATION =	"group_transportation";
	public static final String PRACTICER_GROUP_WEATHER = "group_weather";
	public static final String PRACTICER_GROUP_FIGHT_MASTER = "group_fightmaster";
	public static final String PRACTICER_GROUP_SUDDEN_DEATH = "group_suddendeath";
	public static final String PRACTICER_GROUP_MEDITATION = "group_meditation";
	public static final String PRACTICER_GROUP_CABAL = "group_cabal";
	public static final String PRACTICER_GROUP_DEFENSIVE = "group_defensive";
	public static final String PRACTICER_GROUP_WIZARD =	"group_wizard";
	
	public static final List<Spell> SPELLS_LIST;
	static {
		SPELLS_LIST = new ArrayList<>();
		SPELLS_LIST.add(new Spell("reserved",  0));
		SPELLS_LIST.add(new Spell("absorb", 707));
		SPELLS_LIST.add(new Spell("acetum primus", 654));
		SPELLS_LIST.add(new Spell("acid arrow", 644));
		SPELLS_LIST.add(new Spell("acid blast", 70));
		SPELLS_LIST.add(new Spell("acute vision", 514));
		SPELLS_LIST.add(new Spell("adamantite golem", 665));
		SPELLS_LIST.add(new Spell("aid", 680));
		SPELLS_LIST.add(new Spell("amnesia", 538));
		SPELLS_LIST.add(new Spell("animate dead", 581));
		SPELLS_LIST.add(new Spell("animate object", 709));
		SPELLS_LIST.add(new Spell("armor",  1));
		SPELLS_LIST.add(new Spell("assist", 670));
		SPELLS_LIST.add(new Spell("astral walk", 622));
		SPELLS_LIST.add(new Spell("attract other", 580));
		SPELLS_LIST.add(new Spell("bark skin", 515));
		SPELLS_LIST.add(new Spell("black death", 677));
		SPELLS_LIST.add(new Spell("blade barrier", 679));
		SPELLS_LIST.add(new Spell("bless",  3));
		SPELLS_LIST.add(new Spell("bless weapon", 637));
		SPELLS_LIST.add(new Spell("blindness",  4));
		SPELLS_LIST.add(new Spell("bluefire", 660));
		SPELLS_LIST.add(new Spell("burning hands",  5));
		SPELLS_LIST.add(new Spell("call lightning",  6));
		SPELLS_LIST.add(new Spell("calm", 509));
		SPELLS_LIST.add(new Spell("cancellation", 507));
		SPELLS_LIST.add(new Spell("cause critical", 63));
		SPELLS_LIST.add(new Spell("cause light", 62));
		SPELLS_LIST.add(new Spell("cause serious", 64));
		SPELLS_LIST.add(new Spell("caustic font", 653));
		SPELLS_LIST.add(new Spell("chain lightning", 500));
		SPELLS_LIST.add(new Spell("charm person",  7));
		SPELLS_LIST.add(new Spell("chromatic orb", 714));
		SPELLS_LIST.add(new Spell("control undead", 669));
		SPELLS_LIST.add(new Spell("chill touch",  8));
		SPELLS_LIST.add(new Spell("colour spray", 10));
		SPELLS_LIST.add(new Spell("continual light", 57));
		SPELLS_LIST.add(new Spell("control weather", 11));
		SPELLS_LIST.add(new Spell("corruption", 671));
		SPELLS_LIST.add(new Spell("create food", 12));
		SPELLS_LIST.add(new Spell("create rose", 511));
		SPELLS_LIST.add(new Spell("create spring", 80));
		SPELLS_LIST.add(new Spell("create water", 13));
		SPELLS_LIST.add(new Spell("cure blindness", 14));
		SPELLS_LIST.add(new Spell("cure critical", 15));
		SPELLS_LIST.add(new Spell("cure disease", 501));
		SPELLS_LIST.add(new Spell("cure light", 16));
		SPELLS_LIST.add(new Spell("cure poison", 43));
		SPELLS_LIST.add(new Spell("cure serious", 61));
		SPELLS_LIST.add(new Spell("curse", 17));
		SPELLS_LIST.add(new Spell("cursed lands", 675));
		SPELLS_LIST.add(new Spell("deadly venom", 674));
		SPELLS_LIST.add(new Spell("deafen", 570));
		SPELLS_LIST.add(new Spell("demonfire", 505));
		SPELLS_LIST.add(new Spell("desert fist", 681));
		SPELLS_LIST.add(new Spell("detect evil", 18));
		SPELLS_LIST.add(new Spell("detect good", 513));
		SPELLS_LIST.add(new Spell("detect hide", 0));
		SPELLS_LIST.add(new Spell("detect invis", 19));
		SPELLS_LIST.add(new Spell("detect magic", 20));
		SPELLS_LIST.add(new Spell("detect poison", 21));
		SPELLS_LIST.add(new Spell("detect undead", 594));
		SPELLS_LIST.add(new Spell("disenchant armor", 705));
		SPELLS_LIST.add(new Spell("disenchant weapon", 706));
		SPELLS_LIST.add(new Spell("disintegrate", 574));
		SPELLS_LIST.add(new Spell("dismantle", 621));
		SPELLS_LIST.add(new Spell("dispel evil", 22));
		SPELLS_LIST.add(new Spell("dispel good", 512));
		SPELLS_LIST.add(new Spell("dispel magic", 59));
		SPELLS_LIST.add(new Spell("disruption", 648));
		SPELLS_LIST.add(new Spell("dragon breath", 563));
		SPELLS_LIST.add(new Spell("dragon skin", 612));
		SPELLS_LIST.add(new Spell("dragon strength", 562));
		SPELLS_LIST.add(new Spell("dragons breath", 576));
		SPELLS_LIST.add(new Spell("drain", 704));
		SPELLS_LIST.add(new Spell("earthfade", 702));
		SPELLS_LIST.add(new Spell("earthmaw", 703));
		SPELLS_LIST.add(new Spell("earthquake", 23));
		SPELLS_LIST.add(new Spell("elemental sphere", 719));
		SPELLS_LIST.add(new Spell("enchant armor", 510));
		SPELLS_LIST.add(new Spell("enchant weapon", 24));
		SPELLS_LIST.add(new Spell("energy drain", 25));
		SPELLS_LIST.add(new Spell("enhanced armor", 583));
		SPELLS_LIST.add(new Spell("enlarge", 711));
		SPELLS_LIST.add(new Spell("etheral fist", 645));
		SPELLS_LIST.add(new Spell("faerie fire", 72));
		SPELLS_LIST.add(new Spell("faerie fog", 73));
		SPELLS_LIST.add(new Spell("farsight", 521));
		SPELLS_LIST.add(new Spell("fear", 598));
		SPELLS_LIST.add(new Spell("fire and ice", 699));
		SPELLS_LIST.add(new Spell("fireball", 26));
		SPELLS_LIST.add(new Spell("fireproof", 523));
		SPELLS_LIST.add(new Spell("firestream", 692));
		SPELLS_LIST.add(new Spell("fire shield", 601));
		SPELLS_LIST.add(new Spell("flamestrike", 65));
		SPELLS_LIST.add(new Spell("fly", 56));
		SPELLS_LIST.add(new Spell("floating disc", 522));
		SPELLS_LIST.add(new Spell("forcecage", 717));
		SPELLS_LIST.add(new Spell("frenzy", 504));
		SPELLS_LIST.add(new Spell("frostbolt", 695));
		SPELLS_LIST.add(new Spell("fumble", 712));
		SPELLS_LIST.add(new Spell("galvanic whip", 655));
		SPELLS_LIST.add(new Spell("gate", 83));
		SPELLS_LIST.add(new Spell("giant strength", 39));
		SPELLS_LIST.add(new Spell("grounding", 700));
		SPELLS_LIST.add(new Spell("group defense", 586));
		SPELLS_LIST.add(new Spell("group heal", 642));
		SPELLS_LIST.add(new Spell("hallucination", 606));
		SPELLS_LIST.add(new Spell("hand of undead", 647));
		SPELLS_LIST.add(new Spell("harm", 27));
		SPELLS_LIST.add(new Spell("haste", 502));
		SPELLS_LIST.add(new Spell("heal", 28));
		SPELLS_LIST.add(new Spell("healing light", 613));
		SPELLS_LIST.add(new Spell("heat metal", 516));
		SPELLS_LIST.add(new Spell("helical flow", 661));
		SPELLS_LIST.add(new Spell("hellfire", 520));
		SPELLS_LIST.add(new Spell("holy aura", 617));
		SPELLS_LIST.add(new Spell("holy fury", 682));
		SPELLS_LIST.add(new Spell("holy word", 506));
		SPELLS_LIST.add(new Spell("hurricane", 672));
		SPELLS_LIST.add(new Spell("hydroblast", 684));
		SPELLS_LIST.add(new Spell("iceball", 513));
		SPELLS_LIST.add(new Spell("identify", 53));
		SPELLS_LIST.add(new Spell("improved detect", 626));
		SPELLS_LIST.add(new Spell("improved invis", 627));
		SPELLS_LIST.add(new Spell("infravision", 77));
		SPELLS_LIST.add(new Spell("insanity", 616));
		SPELLS_LIST.add(new Spell("inspire", 587));
		SPELLS_LIST.add(new Spell("invisibility", 29));
		SPELLS_LIST.add(new Spell("iron body", 718));
		SPELLS_LIST.add(new Spell("iron golem", 664));
		SPELLS_LIST.add(new Spell("knock", 603));
		SPELLS_LIST.add(new Spell("know alignment", 58));
		SPELLS_LIST.add(new Spell("lesser golem", 662));
		SPELLS_LIST.add(new Spell("lethargic mist", 676));
		SPELLS_LIST.add(new Spell("light arrow", 683));
		SPELLS_LIST.add(new Spell("lightning bolt", 30));
		SPELLS_LIST.add(new Spell("lightning shield", 614));
		SPELLS_LIST.add(new Spell("link", 588));
		SPELLS_LIST.add(new Spell("lion help", 595));
		SPELLS_LIST.add(new Spell("locate object", 31));
		SPELLS_LIST.add(new Spell("love potion", 666));
		SPELLS_LIST.add(new Spell("magic jar", 596));
		SPELLS_LIST.add(new Spell("magic missile", 32));
		SPELLS_LIST.add(new Spell("magic resistance", 605));
		SPELLS_LIST.add(new Spell("magnetic trust", 656));
		SPELLS_LIST.add(new Spell("mass healing", 508));
		SPELLS_LIST.add(new Spell("mass invis", 69));
		SPELLS_LIST.add(new Spell("mass sanctuary", 589));
		SPELLS_LIST.add(new Spell("master healing", 641));
		SPELLS_LIST.add(new Spell("meld into stone", 584));
		SPELLS_LIST.add(new Spell("mend", 590));
		SPELLS_LIST.add(new Spell("mind light", 82));
		SPELLS_LIST.add(new Spell("mind wrack", 650));
		SPELLS_LIST.add(new Spell("mind wrench", 651));
		SPELLS_LIST.add(new Spell("mist walk", 658));
		SPELLS_LIST.add(new Spell("mummify", 715));
		SPELLS_LIST.add(new Spell("mysterious dream", 678));
		SPELLS_LIST.add(new Spell("nexus", 520));
		SPELLS_LIST.add(new Spell("pass door", 74));
		SPELLS_LIST.add(new Spell("plague", 503));
		SPELLS_LIST.add(new Spell("poison", 33));
		SPELLS_LIST.add(new Spell("polymorph", 639));
		SPELLS_LIST.add(new Spell("portal", 519));
		SPELLS_LIST.add(new Spell("protection cold", 600));
		SPELLS_LIST.add(new Spell("protection evil", 34));
		SPELLS_LIST.add(new Spell("protection good", 666));
		SPELLS_LIST.add(new Spell("protection heat", 599));
		SPELLS_LIST.add(new Spell("protection negative", 636));
		SPELLS_LIST.add(new Spell("protective shield", 572));
		SPELLS_LIST.add(new Spell("power word kill", 604));
		SPELLS_LIST.add(new Spell("power word stun", 625));
		SPELLS_LIST.add(new Spell("quantum spike", 657));
		SPELLS_LIST.add(new Spell("ranger staff", 519));
		SPELLS_LIST.add(new Spell("ray of truth", 518));
		SPELLS_LIST.add(new Spell("recharge", 517));
		SPELLS_LIST.add(new Spell("refresh", 81));
		SPELLS_LIST.add(new Spell("reincarnation", 668));
		SPELLS_LIST.add(new Spell("remove curse", 35));
		SPELLS_LIST.add(new Spell("remove fear", 582));
		SPELLS_LIST.add(new Spell("remove tattoo", 552));
		SPELLS_LIST.add(new Spell("resilience",  638));
		SPELLS_LIST.add(new Spell("restoring light", 643));
		SPELLS_LIST.add(new Spell("sanctify lands", 673));
		SPELLS_LIST.add(new Spell("sanctuary", 36));
		SPELLS_LIST.add(new Spell("sand storm", 577));
		SPELLS_LIST.add(new Spell("scream", 578));
		SPELLS_LIST.add(new Spell("severity force", 622));
		SPELLS_LIST.add(new Spell("shield", 67));
		SPELLS_LIST.add(new Spell("shielding", 591));
		SPELLS_LIST.add(new Spell("shocking grasp", 53));
		SPELLS_LIST.add(new Spell("shocking trap", 615));
		SPELLS_LIST.add(new Spell("sleep", 38));
		SPELLS_LIST.add(new Spell("slow", 515));
		SPELLS_LIST.add(new Spell("soften", 713));
		SPELLS_LIST.add(new Spell("solar flight", 659));
		SPELLS_LIST.add(new Spell("sonic resonance", 649));
		SPELLS_LIST.add(new Spell("soul bind", 716));
		SPELLS_LIST.add(new Spell("spectral furor", 646));
		SPELLS_LIST.add(new Spell("stone golem", 663));
		SPELLS_LIST.add(new Spell("stone skin", 66));
		SPELLS_LIST.add(new Spell("suffocate", 714));
		SPELLS_LIST.add(new Spell("sulfurus spray", 652));
		SPELLS_LIST.add(new Spell("summon", 40));
		SPELLS_LIST.add(new Spell("summon air elemental", 696));
		SPELLS_LIST.add(new Spell("summon earth elemental", 693));
		SPELLS_LIST.add(new Spell("summon fire elemental", 697));
		SPELLS_LIST.add(new Spell("summon lightning elemental", 710));
		SPELLS_LIST.add(new Spell("summon water elemental", 698));
		SPELLS_LIST.add(new Spell("summon shadow", 620));
		SPELLS_LIST.add(new Spell("superior heal", 640));
		SPELLS_LIST.add(new Spell("tattoo", 551));
		SPELLS_LIST.add(new Spell("teleport",  2));
		SPELLS_LIST.add(new Spell("transfer object", 708));
		SPELLS_LIST.add(new Spell("tsunami", 701));
		SPELLS_LIST.add(new Spell("turn", 597));
		SPELLS_LIST.add(new Spell("vampiric blast", 611));
		SPELLS_LIST.add(new Spell("ventriloquate", 41));
		SPELLS_LIST.add(new Spell("web", 592));
		SPELLS_LIST.add(new Spell("windwall", 694));
		SPELLS_LIST.add(new Spell("witch curse", 602));
		SPELLS_LIST.add(new Spell("wrath", 553));
		SPELLS_LIST.add(new Spell("weaken", 68));
		SPELLS_LIST.add(new Spell("word of recall", 42));
		SPELLS_LIST.add(new Spell("acid breath", 200));
		SPELLS_LIST.add(new Spell("desert heat", 629));
		SPELLS_LIST.add(new Spell("fire breath", 201));
		SPELLS_LIST.add(new Spell("frost breath", 202));
		SPELLS_LIST.add(new Spell("gas breath", 203));
		SPELLS_LIST.add(new Spell("lightning breath", 204));
		SPELLS_LIST.add(new Spell("lightning stroke", 632));
		SPELLS_LIST.add(new Spell("luck bonus",  630));
		SPELLS_LIST.add(new Spell("paralyzation", 631));
		SPELLS_LIST.add(new Spell("repulsion", 633));
		SPELLS_LIST.add(new Spell("sleep gas", 628));
		SPELLS_LIST.add(new Spell("slow gas", 634));
	}

	
//	public static final Integer SIZE_TINY = 0;
//	public static final Integer SIZE_SMALL = 1;
//	public static final Integer SIZE_MEDIUM = 2;
//	public static final Integer SIZE_LARGE = 3;
//	public static final Integer SIZE_HUGE = 4;
//	public static final Integer SIZE_GIANT = 5;
//	public static final Integer SIZE_GARGANTUAN = 6;
	
	public enum Size {
		TINY(0, "tiny"),
		SMALL(1, "small"),
		MEDIUM(2, "medium"),
		LARGE(3, "large"),
		HUGE(4, "huge"),
		GIANT(5, "giant"),
		GARGANTUAN(6, "gargantuan");
		
		private static final Map<Integer, Size> BY_NUM = new HashMap<>();
		private static final Map<String, Size> BY_NAME = new HashMap<>();
		
		static {
			for (Size e: values()) {
				BY_NUM.put(e.num, e);
				BY_NAME.put(e.name, e);
			}
		}
		
		public final int num;
		public final String name;
		private Size(int num, String name) {
			this.num = num;
			this.name = name;
		}
		
		public static Size valueOfNum(int num) {
			return BY_NUM.get(num);
		}
		public static Size valueOfName(String name) {
			return BY_NAME.get(name);
		}
	}
	
	//redundant?
	public static final Integer RACE_TYPE_AARAKOCRA = 0;
	public static final Integer RACE_TYPE_AIR_ELEMENTAL = 1;
	public static final Integer RACE_TYPE_ARIAL = 2;
	public static final Integer RACE_TYPE_BAT = 3;
	public static final Integer RACE_TYPE_BEAR = 4;
	public static final Integer RACE_TYPE_BEHOLDER = 5;
	public static final Integer RACE_TYPE_BLACK_DRAGON = 6;
	public static final Integer RACE_TYPE_BLUE_DRAGON = 7;
	public static final Integer RACE_TYPE_BRASS_DRAGON = 8;
	public static final Integer RACE_TYPE_BRONZE_DRAGON = 9;
	public static final Integer RACE_TYPE_CAT = 10;
	public static final Integer RACE_TYPE_CENTAUR = 11;
	public static final Integer RACE_TYPE_CENTIPEDE = 12;
	public static final Integer RACE_TYPE_CLOUD_GIANT = 13;
	public static final Integer RACE_TYPE_COPPER_DRAGON = 14;
	public static final Integer RACE_TYPE_DEATH_KNIGHT = 15;
	public static final Integer RACE_TYPE_DARK_ELF = 16;
	public static final Integer RACE_TYPE_DOG = 17;
	public static final Integer RACE_TYPE_DOLL = 18;
	public static final Integer RACE_TYPE_DRACOLICH = 19;
	public static final Integer RACE_TYPE_DRACONIAN = 20;
	public static final Integer RACE_TYPE_DRAGON = 21;
	public static final Integer RACE_TYPE_DROW = 22;
	public static final Integer RACE_TYPE_DUERGAR = 23;
	public static final Integer RACE_TYPE_DWARF = 24;
	public static final Integer RACE_TYPE_EARTH_ELEMENTAL = 25;
	public static final Integer RACE_TYPE_ELF = 26;
	public static final Integer RACE_TYPE_FELAR = 27;
	public static final Integer RACE_TYPE_FIDO = 28;
	public static final Integer RACE_TYPE_FIRE_ELEMENTAL = 29;
	public static final Integer RACE_TYPE_FIRE_GIANT = 30;
	public static final Integer RACE_TYPE_FISH = 31;
	public static final Integer RACE_TYPE_FOX = 32;
	public static final Integer RACE_TYPE_FROST_GIANT = 33;
	public static final Integer RACE_TYPE_GARGOYLE = 34;
	public static final Integer RACE_TYPE_GITHYANKI = 35;
	public static final Integer RACE_TYPE_GHOST = 36;
	public static final Integer RACE_TYPE_GHOUL = 37;
	public static final Integer RACE_TYPE_GIANT = 38;
	public static final Integer RACE_TYPE_GNOLL = 39;
	public static final Integer RACE_TYPE_GNOME = 40;
	public static final Integer RACE_TYPE_GOBLIN = 41;
	public static final Integer RACE_TYPE_GOLD_DRAGON = 42;
	public static final Integer RACE_TYPE_GOLEM = 43;
	public static final Integer RACE_TYPE_GREEN_DRAGON = 44;
	public static final Integer RACE_TYPE_HALF_ELF = 45;
	public static final Integer RACE_TYPE_HARPY = 46;
	public static final Integer RACE_TYPE_HOBGOBLIN = 47;
	public static final Integer RACE_TYPE_HORSE = 48;
	public static final Integer RACE_TYPE_HUMAN = 49;
	public static final Integer RACE_TYPE_KOBOLD = 50;
	public static final Integer RACE_TYPE_LAMIA = 51;
	public static final Integer RACE_TYPE_LICH = 52;
	public static final Integer RACE_TYPE_LION = 53;
	public static final Integer RACE_TYPE_LIZARD = 54;
	public static final Integer RACE_TYPE_MINOTAUR = 55;
	public static final Integer RACE_TYPE_MODRON = 56;
	public static final Integer RACE_TYPE_OGRE = 57;
	public static final Integer RACE_TYPE_ORC = 58;
	public static final Integer RACE_TYPE_PIG = 59;
	public static final Integer RACE_TYPE_RABBIT = 60;
	public static final Integer RACE_TYPE_RED_DRAGON = 61;
	public static final Integer RACE_TYPE_ROCKSEER = 62;
	public static final Integer RACE_TYPE_SATYR = 63;
	public static final Integer RACE_TYPE_SCHOOL_MONSTER = 64;
	public static final Integer RACE_TYPE_SILVER_DRAGON = 65;
	public static final Integer RACE_TYPE_SNAKE = 66;
	public static final Integer RACE_TYPE_SONG_BIRD = 67;
	public static final Integer RACE_TYPE_SPRITE = 68;
	public static final Integer RACE_TYPE_STORM_GIANT = 69;
	public static final Integer RACE_TYPE_SVIRFNEBLI = 70;
	public static final Integer RACE_TYPE_TIGER = 71;
	public static final Integer RACE_TYPE_TROLL = 72;
	public static final Integer RACE_TYPE_UNDEAD = 73;
	public static final Integer RACE_TYPE_WATER_ELEMENTAL = 74;
	public static final Integer RACE_TYPE_WATER_FOWL = 75;
	public static final Integer RACE_TYPE_WHITE_DRAGON = 76;
	public static final Integer RACE_TYPE_WOLF = 77;
	public static final Integer RACE_TYPE_WYVERN = 78;
	public static final Integer RACE_TYPE_ZOMBIE = 79;

	//TODO:fix room flags
	public static final Integer ROOM_FLAG_NO_RECALL = 0;
	public static final Integer ROOM_FLAG_NO_MAGIC = 1;
	public static final Integer ROOM_FLAG_NOSUMMON = 2;
	public static final Integer ROOM_FLAG_NOWHERE = 3;
	public static final Integer ROOM_FLAG_DARK = 4;
	public static final Integer ROOM_FLAG_INDOORS = 5;
	public static final Integer ROOM_FLAG_BANK = 6;
	public static final Integer ROOM_FLAG_PET_SHOP = 7;
	public static final Integer ROOM_FLAG_NO_MOB = 8;
	public static final Integer ROOM_FLAG_SAFE = 9;
	public static final Integer ROOM_FLAG_PRIVATE = 10;
	public static final Integer ROOM_FLAG_SOLITARY = 11;
	public static final Integer ROOM_FLAG_NEWBIES_ONLY = 12;
	public static final Integer ROOM_FLAG_HEROES_ONLY = 13;
	public static final Integer ROOM_FLAG_GODS_ONLY = 14;
	public static final Integer ROOM_FLAG_IMP_ONLY = 15;
	public static final Integer ROOM_FLAG_LAW = 16;
	public static final Integer ROOM_FLAG_REGISTRY = 17;
	public static final Integer ROOM_FLAG_RANDOM = 18;
	
	public static final Integer ROOM_SECTOR_INSIDE = 0;
	public static final Integer ROOM_SECTOR_CITY = 1;
	public static final Integer ROOM_SECTOR_FIELD = 2;
	public static final Integer ROOM_SECTOR_FOREST = 3;
	public static final Integer ROOM_SECTOR_HILL = 4;
	public static final Integer ROOM_SECTOR_MOUNTAIN = 5;
	public static final Integer ROOM_SECTOR_WATER = 6;
	public static final Integer ROOM_SECTOR_DEEPWATER = 7;
	public static final Integer ROOM_SECTOR_UNUSED = 8;
	public static final Integer ROOM_SECTOR_AIR = 9;
	public static final Integer ROOM_SECTOR_DESERT = 10;
	
	public static final String WEAPON_TYPE_EXOTIC = "exotic";
	public static final String WEAPON_TYPE_SWORD = "sword";
	public static final String WEAPON_TYPE_DAGGER = "dagger";
	public static final String WEAPON_TYPE_SPEAR = "spear";
	public static final String WEAPON_TYPE_MACE = "mace";
	public static final String WEAPON_TYPE_AXE = "axe";
	public static final String WEAPON_TYPE_FLAIL = "flail";
	public static final String WEAPON_TYPE_WHIP = "whip";
	public static final String WEAPON_TYPE_POLEARM = "polearm";
	public static final String WEAPON_TYPE_BOW = "bow";
	public static final String WEAPON_TYPE_ARROW = "arrow";
	public static final String WEAPON_TYPE_LANCE = "lance";
	
	//TODO: fix weapon flags
	public static final Integer WEAPON_FLAG_FLAMING = 0;
	public static final Integer WEAPON_FLAG_FROST = 1;
	public static final Integer WEAPON_FLAG_VAMPIRIC = 2;
	public static final Integer WEAPON_FLAG_SHARP = 3;
	public static final Integer WEAPON_FLAG_VORPAL = 4;
	public static final Integer WEAPON_FLAG_TWO_HANDED = 5;
	public static final Integer WEAPON_FLAG_SHOCKING = 6;
	public static final Integer WEAPON_FLAG_POISONED = 7;
	public static final Integer WEAPON_FLAG_HOLY = 8;
	public static final Integer WEAPON_FLAG_KATANA = 9;
	public static final Integer WEAPON_FLAG_NIGHTMARE = 10;
	
	public static final String DAMAGE_TYPE_PIERCE = "pierce";
	public static final String DAMAGE_TYPE_BASH = "bash";
	public static final String DAMAGE_TYPE_SLASH = "slash";
	public static final String DAMAGE_TYPE_MAGIC = "magic";
	public static final String DAMAGE_TYPE_NONE = "none";
	
	
}