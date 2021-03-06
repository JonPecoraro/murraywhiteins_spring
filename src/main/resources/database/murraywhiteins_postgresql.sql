/*
File name: C:\Users\jpeco\Desktop\murraywhiteins_postgresql.sql
Creation date: 07/09/2017
Created by MySQL to PostgreSQL 3.3 [Demo]
--------------------------------------------------
More conversion tools at http://www.convert-in.com
*/

/*
Table structure for table 'public.represented_company'
*/

DROP TABLE IF EXISTS "public"."represented_company" CASCADE;
CREATE TABLE "public"."represented_company" (
	"id" SERIAL NOT NULL,
	"name" VARCHAR(255)  NOT NULL,
	"phone" VARCHAR(255)  NOT NULL,
	"url" VARCHAR(255)  NOT NULL,
	"image" VARCHAR(255)  NOT NULL,
	"sort_order" INT  NULL,
	"date_created" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	"date_updated" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
) WITH OIDS;
DROP INDEX IF EXISTS "PRIMARY";
ALTER TABLE "public"."represented_company" ADD CONSTRAINT "PRIMARY" PRIMARY KEY("id");

/*
Dumping data for table 'public.represented_company'
*/

INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (1, 'Aetna', '800-872-3862', 'https://www.aetna.com', '/logos/aetna.jpg', 1, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (2, 'AlwaysCare Benefits', '888-729-5433', 'http://www.alwayscarebenefits.com', '/logos/alwaysCareBenefits.jpg', 2, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (3, 'American Strategic Insurance', '866-274-8765', 'http://www.americanstrategic.com', '/logos/americanStrategicInsurance.jpg', 3, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (4, 'Auto-Owners Insurance', '800-346-0346', 'http://www.auto-owners.com/', '/logos/autoOwners.jpg', 4, '2017-09-30 10:42:41', '2017-09-30 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (5, 'Blue Cross Blue Shield', '800-446-8053', 'http://www.bcbsnc.com', '/logos/blueCrossBlueShield.jpg', 5, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (6, 'Builders Mutual', '800-809-4859', 'https://www.buildersmutual.com', '/logos/buildersMutual.jpg', 6, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (7, 'Community Eye Care', '888-254-4290', 'http://www.communityeyecare.net', '/logos/communityEyeCare.jpg', 7, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (8, 'Companion Life', '800-753-0404', 'http://www.companionlife.com', '/logos/companionLife.jpg', 8, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (9, 'Foremost Insurance Group', '800-527-3907', 'http://www.foremost.com', '/logos/foremostInsuranceGroup.jpg', 9, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (10, 'Guardian Life Insurance', '888-482-7342', 'https://www.guardianlife.com', '/logos/guardian.jpg', 10, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (11, 'Isurity', '336-869-3000', 'http://www.isurity.com', '/logos/isurity.jpg', 11, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (12, 'Jackson Sumner', '800-342-5572', 'https://www.jsausa.com', '/logos/jacksonSumner.jpg', 12, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (13, 'Jefferson Pilot / Lincoln Financial', '800-487-1485', 'https://www.lfg.com/public/individual', '/logos/jeffersonPilotFinancial.jpg', 13, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (14, 'Kansas City Life', '800-821-6164', 'https://www.kclife.com', '/logos/kansasCityLife.jpg', 14, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (15, 'Kemper Insurance Group', '866-860-9348', 'https://www.kemper.com', '/logos/kemperInsuranceGroup.jpg', 15, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (16, 'Liberty Mutual', '888-398-8924', 'https://www.libertymutual.com', '/logos/libertyMutual.jpg', 16, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (17, 'Main Street America Group', '800-226-0875', 'http://www.msagroup.com', '/logos/mainStreetAmericaGroup.jpg', 17, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (18, 'MetLife', '800-438-6388', 'https://www.metlife.com', '/logos/metlife.jpg', 18, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (19, 'Mutual of Omaha', '800-769-7159', 'http://www.mutualofomaha.com', '/logos/mutualOfOmaha.jpg', 19, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (20, 'National Flood Insurance Program', '800-638-6620', 'https://www.fema.gov/national-flood-insurance-program', '/logos/nationalFloodInsuranceProgram.jpg', 20, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (21, 'National General Insurance Company', '800-462-2123', 'http://www.nationalgeneral.com', '/logos/nationalGeneralInsuranceCompany.jpg', 21, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (22, 'Nationwide', '877-669-6877', 'http://www.nationwide.com', '/logos/nation.jpg', 22, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (23, 'Pennsylvania Lumbermens', '800-752-1895', 'http://www.plmilm.com', '/logos/pennsylvaniaLumbermens.jpg', 23, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (24, 'Progressive', '800-776-4737', 'http://www.progressive.com', '/logos/progressive.jpg', 24, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (25, 'SafeCo', '800-332-3226', 'http://www.safeco.com', '/logos/safeCo.jpg', 25, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (26, 'State Auto', '614-464-5000', 'https://www.stateauto.com', '/logos/stateAuto.jpg', 26, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (27, 'Tapco', '800-334-5579', 'http://www.gotapco.com', '/logos/tapco.jpg', 27, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (28, 'United Healthcare', '866-633-2446', 'http://www.uhc.com', '/logos/unitedHealthCare.jpg', 28, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (29, 'Utica National', '804-560-6600', 'http://www.uticanational.com/Insurance', '/logos/uticaNational.jpg', 29, '2017-07-09 10:42:41', '2017-07-09 10:42:41');
INSERT INTO "public"."represented_company"("id", "name", "phone", "url", "image", "sort_order", "date_created", "date_updated") VALUES (30, 'United States Liability Insurance Group', '800-523-5545', 'http://www.usli.com', '/logos/unitedStatesLiabilityInsuranceGroup.jpg', 30, '2017-07-09 10:42:41', '2017-07-09 10:42:41');

/*
Table structure for table 'public.state'
*/

DROP TABLE IF EXISTS "public"."state" CASCADE;
CREATE TABLE "public"."state" (
	"id" SERIAL NOT NULL,
	"abbreviation" VARCHAR(255)  NOT NULL,
	"name" VARCHAR(255)  NOT NULL,
	"date_created" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	"date_updated" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
) WITH OIDS;
DROP INDEX IF EXISTS "PRIMARY";
ALTER TABLE "public"."state" ADD CONSTRAINT "PRIMARY" PRIMARY KEY("id");

/*
Dumping data for table 'public.state'
*/

INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (1, 'AL', 'Alabama', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (2, 'AK', 'Alaska', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (3, 'AZ', 'Arizona', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (4, 'AR', 'Arkansas', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (5, 'CA', 'California', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (6, 'CO', 'Colorado', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (7, 'CT', 'Connecticut', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (8, 'DE', 'Delaware', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (9, 'DC', 'District Of Columbia', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (10, 'FL', 'Florida', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (11, 'GA', 'Georgia', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (12, 'HI', 'Hawaii', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (13, 'ID', 'Idaho', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (14, 'IL', 'Illinois', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (15, 'IN', 'Indiana', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (16, 'IA', 'Iowa', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (17, 'KS', 'Kansas', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (18, 'KY', 'Kentucky', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (19, 'LA', 'Louisiana', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (20, 'ME', 'Maine', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (21, 'MD', 'Maryland', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (22, 'MA', 'Massachusetts', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (23, 'MI', 'Michigan', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (24, 'MN', 'Minnesota', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (25, 'MS', 'Mississippi', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (26, 'MO', 'Missouri', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (27, 'MT', 'Montana', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (28, 'NE', 'Nebraska', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (29, 'NV', 'Nevada', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (30, 'NH', 'New Hampshire', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (31, 'NJ', 'New Jersey', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (32, 'NM', 'New Mexico', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (33, 'NY', 'New York', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (34, 'NC', 'North Carolina', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (35, 'ND', 'North Dakota', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (36, 'OH', 'Ohio', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (37, 'OK', 'Oklahoma', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (38, 'OR', 'Oregon', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (39, 'PA', 'Pennsylvania', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (40, 'RI', 'Rhode Island', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (41, 'SC', 'South Carolina', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (42, 'SD', 'South Dakota', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (43, 'TN', 'Tennessee', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (44, 'TX', 'Texas', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (45, 'UT', 'Utah', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (46, 'VT', 'Vermont', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (47, 'VA', 'Virginia', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (48, 'WA', 'Washington', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (49, 'WV', 'West Virginia', '2017-07-09 10:43:35', '2017-07-09 10:43:35');
INSERT INTO "public"."state"("id", "abbreviation", "name", "date_created", "date_updated") VALUES (50, 'WI', 'Wisconsin', '2017-07-09 10:43:35', '2017-07-09 10:43:35');

/*
Table structure for table 'public.team_member'
*/

DROP TABLE IF EXISTS "public"."team_member" CASCADE;
CREATE TABLE "public"."team_member" (
	"id" SERIAL NOT NULL,
	"first_name" VARCHAR(255)  NOT NULL,
	"last_name" VARCHAR(255)  NOT NULL,
	"suffix" VARCHAR(255) ,
	"email" VARCHAR(255)  NOT NULL,
	"extension" VARCHAR(255) ,
	"position" VARCHAR(255) ,
	"qualifications" VARCHAR(255) ,
	"description" VARCHAR(1023) ,
	"image" VARCHAR(255) ,
	"employment_date" VARCHAR(255) ,
	"sort_order" INT  NULL ,
	"date_created" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	"date_updated" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
) WITH OIDS;
DROP INDEX IF EXISTS "PRIMARY";
ALTER TABLE "public"."team_member" ADD CONSTRAINT "PRIMARY" PRIMARY KEY("id");

/*
Dumping data for table 'public.team_member'
*/
INSERT INTO "public"."team_member"("id", "first_name", "last_name", "suffix", "email", "extension", "position", "qualifications", "description", "image", "employment_date", "sort_order", "date_created", "date_updated") VALUES (1, 'Murray', 'White', 'III', 'm3@murraymwhiteinc.com', '646', 'President', NULL, 'Murray 3, as he is known around the office, joined the family business in 1981. He has taken the lead in recent years to continue to build the Agency on the foundation that was created by his family. Murray 3 is an active agent, who assists clients in all areas of Insurance. When he is not in the office you can find him supporting High Point University Athletics or coaching a local little league baseball team. Murray 3 is happily married and excited to have his son working beside him in the family business.', '/team/murray_white_3.jpg', '0000-00-00', 1, '2017-07-09 10:44:56', '2017-07-09 10:44:56');
INSERT INTO "public"."team_member"("id", "first_name", "last_name", "suffix", "email", "extension", "position", "qualifications", "description", "image", "employment_date", "sort_order", "date_created", "date_updated") VALUES (2, 'Rick', 'Powers', NULL, 'rick@murraymwhiteinc.com', '643', 'Vice President', NULL, 'Rick is an experienced Agent with Murray White Insurance. He�s been selling policies to customers for over 23 years. While Rick is well versed in the industry, he specializes in Health Insurance. When he�s not assisting clients with their health needs, he can be found cheering on many North Carolina spots teams, as he�s a die hard Carolina Panthers, Charlotte Hornets, and UNC Chapel Hill fan. Rick is married with two kids and lives in the Triad.', '/team/rick_powers.jpg', '0000-00-00', 2, '2017-07-09 10:44:56', '2017-07-09 10:44:56');
INSERT INTO "public"."team_member"("id", "first_name", "last_name", "suffix", "email", "extension", "position", "qualifications", "description", "image", "employment_date", "sort_order", "date_created", "date_updated") VALUES (3, 'Murray', 'White', 'IV', 'm4@murraymwhiteinc.com', '638', 'Account Executive', NULL, 'Murray 4, brings some new life to Murray White Insurance. He joined the family business in December of 2013 and is continuing to learn and grow each day. Murray 4 energetically jumped on board with the Property and Casualty side of Insurance and hopes to be able to assist clients in all areas of Insurance soon. Prior to Insurance, Murray worked for the Greensboro Grasshoppers as a Sales Associate right out of college. Murray grew up playing ball at Ledford High School and went on to play baseball at High Point University. In his spare time, he loves to travel with his wife and watch Carolina Sports teams.', '/team/murray_white_4.jpg', '0000-00-00', 3, '2017-07-09 10:44:56', '2017-07-09 10:44:56');
INSERT INTO "public"."team_member"("id", "first_name", "last_name", "suffix", "email", "extension", "position", "qualifications", "description", "image", "employment_date", "sort_order", "date_created", "date_updated") VALUES (4, 'Kim', 'Milan', NULL, 'kim@murraymwhiteinc.com', '644', 'Accounting / Office Manager', NULL, 'Kim is one of the longest running associates at Murray White Insurance Agency. She�s been assisting the office in all accounting activities and Office Manager duties for over 30 years. Kim knows the business inside and out, and can be counted on by her coworkers for anything. Being a native of the Triad, Kim grew up in Trinity and then moved to Lexington with her husband to start her family. She has two wonderful grown children, and loves to read, crochet, and do crafts in her spare time. In addition, Kim is an animal lover, especially her Lab Noodles!', '/team/kim_milan.jpg', '0000-00-00', 4, '2017-07-09 10:44:56', '2017-07-09 10:44:56');
INSERT INTO "public"."team_member"("id", "first_name", "last_name", "suffix", "email", "extension", "position", "qualifications", "description", "image", "employment_date", "sort_order", "date_created", "date_updated") VALUES (5, 'Cindi', 'Michael', NULL, 'cindi@murraymwhiteinc.com', '634', 'Commercial Lines Customer Service Representative', 'CIC, CPIW', 'Cindi is a tenured associate at Murray White Insurance Agency. She has been assisting clients for the past 21 years. Cindi is a native to the Triad, having spent her whole life in Lexington. In her free time, she enjoys spending time with her family, especially her granddaughter.', '/team/cindi_michael.jpg', '0000-00-00', 5, '2017-07-09 10:44:56', '2017-07-09 10:44:56');
INSERT INTO "public"."team_member"("id", "first_name", "last_name", "suffix", "email", "extension", "position", "qualifications", "description", "image", "employment_date", "sort_order", "date_created", "date_updated") VALUES (6, 'Sharon', 'Idol', NULL, 'sharon@murraymwhiteinc.com', '636', 'Commercial Lines Customer Service Representative', 'CISR', 'Sharon is a welcomed new addition to Murray White Insurance! She�s been with the Agency for a year, but comes with 32+ years of insurance experience! Sharon is familiar with the area, having grown up in Forsyth County; she now resides in Davie County with her loving husband. In her free time, you can find Sharon camping, cooking, gardening, or decorating. She has one son who is currently in college studying Fire Protection and Technology.', '/team/sharon_idol.jpg', '0000-00-00', 6, '2017-07-09 10:44:56', '2017-07-09 10:44:56');
INSERT INTO "public"."team_member"("id", "first_name", "last_name", "suffix", "email", "extension", "position", "qualifications", "description", "image", "employment_date", "sort_order", "date_created", "date_updated") VALUES (7, 'Emily', 'Smith', NULL, 'emily@murraymwhiteinc.com', '639', 'Commercial Lines Customer Service Representative', NULL, 'Emily is a new employee at Murray White Insurance. We gladly welcome her to the company!', '/team/emily_smith.jpg', '0000-00-00', 7, '2017-07-09 10:44:56', '2017-07-09 10:44:56');
INSERT INTO "public"."team_member"("id", "first_name", "last_name", "suffix", "email", "extension", "position", "qualifications", "description", "image", "employment_date", "sort_order", "date_created", "date_updated") VALUES (8, 'Phillis', 'Butcher', NULL, 'phillis@murraymwhiteinc.com', '642', 'Personal Lines Customer Service Representative', 'CPIA', 'Phillis has been a familiar face with Murray White Insurance for 20+ years. She is originally from Georgia, but has spent the last 25 years making North Carolina home. In her spare time, you can find Phillis enjoying family time at the beach or cheering on the local baseball and softball teams. She has 2 wonderful children and 4 grandchildren that bring her and her husband great joy.', '/team/phillis_butcher.jpg', '0000-00-00', 8, '2017-07-09 10:44:56', '2017-07-09 10:44:56');
INSERT INTO "public"."team_member"("id", "first_name", "last_name", "suffix", "email", "extension", "position", "qualifications", "description", "image", "employment_date", "sort_order", "date_created", "date_updated") VALUES (9, 'Tara', 'Alexander', NULL, 'tara@murraymwhiteinc.com', '637', 'Personal Lines Customer Service Representative', NULL, 'Tara is a new employee at Murray White Insurance. We gladly welcome her to the company! She has been in the insurance industry for 14 years', '/team/no_image.jpg', '0000-00-00', 9, '2017-07-09 10:44:56', '2017-07-09 10:44:56');
INSERT INTO "public"."team_member"("id", "first_name", "last_name", "suffix", "email", "extension", "position", "qualifications", "description", "image", "employment_date", "sort_order", "date_created", "date_updated") VALUES (10, 'Angie', 'McClure', NULL, 'angie@murraymwhiteinc.com', '630', 'Life &amp; Health Benefit Analyst', 'RHU, CIIP', 'Angie has been with Murray White Insurance for more than 14 years and brings over 30 years of experience in group health, life, disability, and dental insurance. At Murray White Insurance she specializes in Benefits. She�s an active member of the International Association of Insurance Professionals, and previously served as NC Association of Insurance Professionals State President. Outside of the Agency, Angie enjoys line dancing, crafts, traveling, and spending time with friends and family, especially her 4 children and 4 grand-children.', '/team/angie_mcClure.jpg', '0000-00-00', 10, '2017-07-09 10:44:56', '2017-07-09 10:44:56');
INSERT INTO "public"."team_member"("id", "first_name", "last_name", "suffix", "email", "extension", "position", "qualifications", "description", "image", "employment_date", "sort_order", "date_created", "date_updated") VALUES (11, 'Frances', 'Pope', NULL, 'frances@murraymwhiteinc.com', '747', 'Receptionist / Licensing', NULL, 'Frances has been with Murray White Insurance for 5+ years and has 35+ years of experience in the Insurance Industry. Frances was originally from Tennessee, but has spent the majority of her like in the Piedmont area. Her and her husband love the mountains and spending quality time with their 2 children, 8 grand-children, and 2 great grand-children!', '/team/frances_pope.jpg', '0000-00-00', 11, '2017-07-09 10:44:56', '2017-07-09 10:44:56');
INSERT INTO "public"."team_member"("id", "first_name", "last_name", "suffix", "email", "extension", "position", "qualifications", "description", "image", "employment_date", "sort_order", "date_created", "date_updated") VALUES (12, 'Ricky', 'DeLappe', NULL, 'ricky@murraymwhiteinc.com', '648', 'Account Executive', NULL, 'Ricky is a new employee at Murray White Insurance. We gladly welcome him to the company!', '/team/ricky_deLappe.jpg', '0000-00-00', 12, '2017-07-09 10:44:56', '2017-07-09 10:44:56');
INSERT INTO "public"."team_member"("id", "first_name", "last_name", "suffix", "email", "extension", "position", "qualifications", "description", "image", "employment_date", "sort_order", "date_created", "date_updated") VALUES (13, 'Jane', 'Day', NULL, 'murraywhite@murraymwhiteinc.com', '747', 'Part Time Receptionist', NULL, 'Jane is a new employee at Murray White Insurance. We gladly welcome her to the company!', '/team/jane_day.jpg', '0000-00-00', 13, '2018-03-26 10:44:56', '2018-03-26 10:44:56');

/*
Table structure for table 'public.users'
*/

DROP TABLE IF EXISTS "public"."users" CASCADE;
CREATE TABLE "public"."users" (
	"id" SERIAL NOT NULL,
	"name" VARCHAR(255)  NOT NULL,
	"email" VARCHAR(255)  NOT NULL,
	"password" VARCHAR(60)  NOT NULL,
	"date_created" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
	"date_updated" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
) WITH OIDS;
DROP INDEX IF EXISTS "USERS_INDEX";
ALTER TABLE "public"."users" ADD CONSTRAINT "USERS_INDEX" PRIMARY KEY("id");
DROP INDEX IF EXISTS "email";
CREATE UNIQUE INDEX "email" ON "public"."users"("email");

/*
Dumping data for table 'public.users'
*/
INSERT INTO "public"."users"("id", "name", "email", "password", "date_created", "date_updated") VALUES (1, 'Jonathan Pecoraro', 'jonpecoraro@gmail.com', '$2a$10$Lz0ZNSGaWQxTuTPvoYdEhe.uFRzr0XBOBSpK7//WqD4wS6WeXIZpy', '2018-07-14 10:44:56', '2018-07-14 10:44:56');
INSERT INTO "public"."users"("id", "name", "email", "password", "date_created", "date_updated") VALUES (2, 'Murray White IV', 'm4@murraymwhiteinc.com', '$2a$10$Srpp8TMh6BN7/P7ZsqBSm.NgAdPk23EcuRgecN6NxY9Zu2FAMq6TC', '2018-07-14 10:44:56', '2018-07-14 10:44:56');
INSERT INTO "public"."users"("id", "name", "email", "password", "date_created", "date_updated") VALUES (3, 'Kim Milan', 'kim@murraymwhiteinc.com', '$2a$10$Srpp8TMh6BN7/P7ZsqBSm.NgAdPk23EcuRgecN6NxY9Zu2FAMq6TC', '2018-07-14 10:44:56', '2018-07-14 10:44:56');
INSERT INTO "public"."users"("id", "name", "email", "password", "date_created", "date_updated") VALUES (4, 'Robin White', 'rmwhite0119@gmail.com', '$2a$10$Srpp8TMh6BN7/P7ZsqBSm.NgAdPk23EcuRgecN6NxY9Zu2FAMq6TC', '2018-07-14 10:44:56', '2018-07-14 10:44:56');

/*
Table structure for table 'public.testimonial'
*/

DROP TABLE IF EXISTS "public"."testimonial" CASCADE;
CREATE TABLE "public"."testimonial" (
	"id" SERIAL NOT NULL,
	"author" VARCHAR(255)  NOT NULL,
	"testimonial" VARCHAR(4095)  NOT NULL
) WITH OIDS;
DROP INDEX IF EXISTS "PRIMARY";
ALTER TABLE "public"."testimonial" ADD CONSTRAINT "PRIMARY" PRIMARY KEY("id");

/*
Dumping data for table 'public.testimonial'
*/

INSERT INTO "public"."testimonial"("id", "author", "testimonial", "date_created", "date_updated") VALUES (1, 'Jonathan Pecoraro', 'I love Murray White Insurance Agency. They have been serving me well for many years. The agents are always quick to respond and willing to work with my limited budget. They have helped my family and I get back on our feet during trying times.');
INSERT INTO "public"."testimonial"("id", "author", "testimonial", "date_created", "date_updated") VALUES (2, 'Linda Trivetta', 'Knowledgeable and always willing to help when you call them. Very friendly staff.');
INSERT INTO "public"."testimonial"("id", "author", "testimonial", "date_created", "date_updated") VALUES (3, 'Dr. Joseph Fonke', 'Very helpful staff. Helped me find what our family needed as far as health insurance was concerned. Great team, great people and a group of some of the best people in all of High Point.');

/*
Table structure for table 'public.global_message'
*/

DROP TABLE IF EXISTS "public"."global_message" CASCADE;
CREATE TABLE "public"."global_message" (
	"id" SERIAL NOT NULL,
	"message" VARCHAR(4095) NOT NULL,
	"start_showing_date" TIMESTAMP NOT NULL,
	"stop_showing_date" TIMESTAMP NOT NULL
);
DROP INDEX IF EXISTS "GLOBAL_MESSAGE";
ALTER TABLE "public"."global_message" ADD CONSTRAINT "GLOBAL_MESSAGE" PRIMARY KEY("id");

/*
Dumping data for table 'public.global_message'
*/

INSERT INTO "public"."global_message"("id",  "message", "start_showing_date", "stop_showing_date") VALUES (1, '', '2017-08-27 10:44:56', '2017-08-27 10:44:56');
