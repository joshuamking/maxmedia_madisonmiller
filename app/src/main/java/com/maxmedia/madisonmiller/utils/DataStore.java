package com.maxmedia.madisonmiller.utils;

import com.maxmedia.madisonmiller.R;
import com.maxmedia.madisonmiller.model.HomeScreenItem;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Joshua King on 1/20/17.
 */
public class DataStore {
	private static ArrayList<HomeScreenItem> homeScreenItems;

	static {
		homeScreenItems = new ArrayList<>();

		homeScreenItems.add(new HomeScreenItem("Shirtwaist Taffeta Ball Gown",
											   "Carolina Herrera evening gown in two-tone silk taffeta. Approx. length: 61L from shoulder to hem, 68L down center back. Convertible spread collar with contrasting buttons. Three-quarter sleeves with French cuffs. Skirt has self belt. Slash pockets. Softly pleated, A-line skirt. Floor-sweeping hem. Silk; dry clean. Made in Italy.",
											   "$4,290.00",
											   R.drawable.ball_gown));
		homeScreenItems.add(new HomeScreenItem("Canada Goose Fur-Trimmed Down-Filled Trillium Parka",
											   "Combining comfort and sleek style, with luxurious fur trim and a long, mid-thigh length. Removable two-way adjustable tunnel hood with adjustable bracing wire for high-wind protectionRemovable fur trim Two-way locking front zipperRecessed, heavy-duty knit inner cuffs Fleece-lined hand warmer pocketsOne inside pocket with grip-tape closure Inside drawstring waistLinedAbout 36\" from shoulder to hemWater-repellent polyester/cotton shell Fill: White duck down/feathersFur type: Natural coyoteFur origin: Canada Dry clean by fur specialistImported ",
											   "$900.00",
											   R.drawable.goose_fur_jacket));
		homeScreenItems.add(new HomeScreenItem("PBI Chilliwack Down Bomber Jacket",
											   "Inspired by the heritage style of bush pilots, this snow-ready bomber jacket flaunts extra warm duck down insulation and coyote fur trim for the perfect mix of athletic and elegant style.",
											   "$800.00",
											   R.drawable.canada_goose));
		homeScreenItems.add(new HomeScreenItem("Embroidered Printed Gown",
											   "Opt for Valentino's beautiful astrology-inspired gown for your next special occasion. The floor-skimming gown is crafted in a night black fabric, with divine gold-tone lace embroidery, mesh inserts and a a breathtaking intergalactic print. Delicate sheer tulle sleeves complete this statement piece, adding the ultimate feminine touch.",
											   "$8,340.00",
											   R.drawable.printed_gown));
		homeScreenItems.add(new HomeScreenItem("Equipment Slim Signature Silk Shirt",
											   "Clusters of stars float over a contrast background on a cool silk blouse from Equipment. Tonal buttons fasten the placket, and flap pockets detail the front",
											   "$248.00",
											   R.drawable.silk_shirt));
		homeScreenItems.add(new HomeScreenItem("Warm Women's Pom-pom-embellished Rose Dress",
											   "Crafted in panels of black velvet and black and white folkloric-print plain-weave, WARM's Rose dress is accented at bib with pom-poms and at waist and sleeves with tasseled ties. Split jewel neck, multicolored folkloric-print canvas trim at bib, tasseled ties at waist, tech-poplin trim at short sleeves, tasseled drawstring cuffs 39\" from shoulder to hem (approximately) Slips on Available in Black/Multi 82% viscose, 18% silk; combo: 100% cotton; trim: 100% polyester Dry clean Made in U.S. Our model is 5’10”/178cm and wearing a size Small.",
											   "$519.00",
											   R.drawable.rose_dress));
		homeScreenItems.add(new HomeScreenItem("Bogner Amai-D Jacket with Nuara2 Natural Fur",
											   "Ice flowers: Make the slopes blossom with this down ski jacket that is scattered with embroidered flowers in black & champagne, and is moreover embellished with square strass stones along the 2-way zip and contrast stripes. Clean back; hood with fur trim option Nuara, which may be ordered separately. Down ski jacket with floral embroidery & strass; Ultra-light ripstop; Waterproof (20,000 mm), breathable (20,000 g/m2/24h); Slightly tailored silhouette; Hood with “B” logo in champagne-colored Swarovski crystals, black mesh lining, and fur trim option Nuara, which may be ordered separately; Two-way zip; Two side zip pockets; Single zip sleeves pocket; Single zip pocket inside; Horizontal quilting, slimmer at the sides; Black-and-champagne-colored floral motifs; Champagne-colored grosgrain ribbon with tonal, square strass along the front zip; Champagne-colored stripes at the hemlines, doubled at the sleeves; Eyelet accents; Gold-toned hardware; Snow gaiter at the bottom hemline; Lining 100 % polyamide; Filling 90 % goose down, 10 % feathers; 62 cm (24.4\") length",
											   "$2,190.00",
											   R.drawable.natural_fur_jacket));
		homeScreenItems.add(new HomeScreenItem("Stella Mccartney Women's Ruched Silk Crêpe De Chine Minidress",
											   "Smooth, fluid bell sleeves mimicked along the skirt hem create stark yet soft contrast with the impeccably ruched body that hugs and highlights a feminine silhouette. Color(s): blue. Brand: STELLA MCCARTNEY. Style Name:Stella Mccartney Ruched Silk Dress. Style Number: 5239131. Available in stores.",
											   "$1,365.00",
											   R.drawable.de_chine_minidress));
		Collections.sort(homeScreenItems);
	}

	public static ArrayList<HomeScreenItem> getHomeScreenItems () {
		Collections.sort(homeScreenItems);
		return homeScreenItems;
	}
}
