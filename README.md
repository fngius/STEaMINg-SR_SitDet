# Stream Reasoning for Abnormal Situation Detection in Industry 4.0

## Usage
1. Clone the repo.

```bash
https://gitlab.insa-rouen.fr/fgiustozzi/STEaMINg-SR_SitDet.git
```
2. Import the project using an IDE such as Eclipse or Visual Studio Code (maven should be installed).

3. Make sure that the path to the ontology is the correct one (Example.java).

Below is the output of the execution considering the case study described [here](https://gitlab.insa-rouen.fr/fgiustozzi/STEaMINg-Onotlogy).

Output:

```bash
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-0 . (1602686482435)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-0 . (1602686482443)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-0 . (1602686482443)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-0 . (1602686482469)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-0 . (1602686482471)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-0 . (1602686482475)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-0 . (1602686482476)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-0 . (1602686482477)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-0 . (1602686482477)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-0 . (1602686482477)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-0 . (1602686482476)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-0 . (1602686482476)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-0 . (1602686482476)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-0 . (1602686482476)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-0 . (1602686482476)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#C_temp . (1602686482511)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#Conv_temp . (1602686482541)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_current . (1602686482580)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PowerOutput . (1602686482611)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#T_temp . (1602686482629)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#P_temp . (1602686482648)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#OilTemp . (1602686482684)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#GB_temp . (1602686482703)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#R_speed . (1602686482722)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_temp . (1602686482783)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_speed . (1602686482765)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#TG_temp . (1602686482803)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#E_temp . (1602686482803)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#C_Wtemp . (1602686482829)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 71^^http://www.w3.org/2001/XMLSchema#double . (1602686482851)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#R_Pangle . (1602686482892)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 16^^http://www.w3.org/2001/XMLSchema#double . (1602686482892)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 877^^http://www.w3.org/2001/XMLSchema#double . (1602686482922)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 43^^http://www.w3.org/2001/XMLSchema#double . (1602686482922)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 712^^http://www.w3.org/2001/XMLSchema#double . (1602686482947)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_E_temp-0 . (1602686482972)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 55^^http://www.w3.org/2001/XMLSchema#double . (1602686483018)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 47^^http://www.w3.org/2001/XMLSchema#double . (1602686482994)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 196^^http://www.w3.org/2001/XMLSchema#double . (1602686483040)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 57^^http://www.w3.org/2001/XMLSchema#double . (1602686483069)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_temp-0 . (1602686483089)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 31^^http://www.w3.org/2001/XMLSchema#double . (1602686483125)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 76^^http://www.w3.org/2001/XMLSchema#double . (1602686483107)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_T_temp-0 . (1602686483184)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 425^^http://www.w3.org/2001/XMLSchema#double . (1602686483162)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 44^^http://www.w3.org/2001/XMLSchema#double . (1602686483229)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_speed-0 . (1602686483254)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_temp-0 . (1602686483291)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_TG_temp-0 . (1602686483309)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_T_temp-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.476^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686483310)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_speed-0 . (1602686483346)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_OilTemp-0 . (1602686483328)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_temp-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.476^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686483346)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_Wtemp-0 . (1602686483382)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_Wtemp-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.435^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686483410)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_E_temp-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.477^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686483410)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_current-0 . (1602686483530)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 4^^http://www.w3.org/2001/XMLSchema#double . (1602686483568)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_PowerOutput-0 . (1602686483550)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_Conv_temp-0 . (1602686483587)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 37^^http://www.w3.org/2001/XMLSchema#double . (1602686483587)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_current-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.477^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686483606)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_OilTemp-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.476^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686483699)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_speed-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.475^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686483737)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_temp-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.443^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686483776)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_GB_temp-0 . (1602686483204)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_speed-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.476^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686483795)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_TG_temp-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.443^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686483827)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_P_temp-0 . (1602686483885)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_Conv_temp-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.476^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686483906)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_Pangle-0 . (1602686483945)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_PowerOutput-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.477^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686483945)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_Pangle-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.469^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686483983)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_P_temp-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.471^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686484017)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_GB_temp-0 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:22.476^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686484095)

S1 NO DETECTED.

S3 NO DETECTED.

S14 NO DETECTED.

S11 NO DETECTED.

S2 NO DETECTED.

S6 NO DETECTED.

S9 NO DETECTED.

S13 NO DETECTED.

S8 NO DETECTED.

S7 NO DETECTED.

S5 NO DETECTED.

S10 NO DETECTED.

S4 NO DETECTED.

S12 NO DETECTED.
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-1 . (1602686490695)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#R_speed . (1602686490777)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-1 . (1602686490778)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-1 . (1602686490777)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#T_temp . (1602686490851)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-1 . (1602686490822)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-1 . (1602686490821)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-1 . (1602686490821)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-1 . (1602686490821)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-1 . (1602686490821)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-1 . (1602686490821)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 56^^http://www.w3.org/2001/XMLSchema#double . (1602686490821)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-1 . (1602686490778)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-1 . (1602686490778)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-1 . (1602686490778)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-1 . (1602686490778)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-1 . (1602686490778)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#TG_temp . (1602686491028)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-1 . (1602686490778)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_speed . (1602686490987)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#GB_temp . (1602686491008)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 53^^http://www.w3.org/2001/XMLSchema#double . (1602686491048)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#Conv_temp . (1602686490967)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PowerOutput . (1602686490938)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#R_Pangle . (1602686490912)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_current . (1602686490887)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#E_temp . (1602686491079)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 5^^http://www.w3.org/2001/XMLSchema#double . (1602686491102)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 992^^http://www.w3.org/2001/XMLSchema#double . (1602686491122)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_Pangle-1 . (1602686491144)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_temp . (1602686491164)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_Pangle-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.821^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686491276)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 27^^http://www.w3.org/2001/XMLSchema#double . (1602686491276)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#C_Wtemp . (1602686491297)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_E_temp-1 . (1602686491317)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 30^^http://www.w3.org/2001/XMLSchema#double . (1602686491337)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 338^^http://www.w3.org/2001/XMLSchema#double . (1602686491357)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_T_temp-1 . (1602686491423)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#C_temp . (1602686491377)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 88^^http://www.w3.org/2001/XMLSchema#double . (1602686491398)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 67^^http://www.w3.org/2001/XMLSchema#double . (1602686491472)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_GB_temp-1 . (1602686491511)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 570^^http://www.w3.org/2001/XMLSchema#double . (1602686491556)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_Conv_temp-1 . (1602686491596)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#P_temp . (1602686491577)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_GB_temp-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.821^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686491596)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 33^^http://www.w3.org/2001/XMLSchema#double . (1602686491617)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_PowerOutput-1 . (1602686491679)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_TG_temp-1 . (1602686491700)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 65^^http://www.w3.org/2001/XMLSchema#double . (1602686491745)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_E_temp-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.778^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686491745)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 49^^http://www.w3.org/2001/XMLSchema#double . (1602686491794)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#OilTemp . (1602686491205)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_speed-1 . (1602686491794)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_current-1 . (1602686491794)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_TG_temp-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.822^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686491889)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_PowerOutput-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.821^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686491910)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_Wtemp-1 . (1602686491864)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_Wtemp-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.778^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686491957)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_temp-1 . (1602686491982)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_T_temp-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.778^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686491982)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 25^^http://www.w3.org/2001/XMLSchema#double . (1602686492050)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_P_temp-1 . (1602686492082)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_P_temp-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.778^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686492118)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_speed-1 . (1602686492147)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_Conv_temp-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.778^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686492147)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_speed-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.695^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686492323)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 70^^http://www.w3.org/2001/XMLSchema#double . (1602686492348)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_temp-1 . (1602686492405)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_temp-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.778^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686492478)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_temp-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.778^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686492479)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_current-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.777^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686492478)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_speed-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.821^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686492552)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_OilTemp-1 . (1602686492736)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_OilTemp-1 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:30.821^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686492799)

S1 NO DETECTED.

S3 NO DETECTED.

S14 NO DETECTED.

S11 NO DETECTED.

S2 NO DETECTED.

S6 DETECTED. 4 result at SystemTime: 1602686493066
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#M3 and http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PL1 are involved in situation S6
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#M3 and http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PL1 are involved in situation S6
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#M3 and http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PL1 are involved in situation S6
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#M3 and http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PL1 are involved in situation S6
CAUSE DETERMINATION DONE.


S9 NO DETECTED.

S13 NO DETECTED.

S8 NO DETECTED.

S7 NO DETECTED.

S5 NO DETECTED.

S10 NO DETECTED.

S4 NO DETECTED.

S12 NO DETECTED.

S1 NO DETECTED.

S3 NO DETECTED.

S14 NO DETECTED.

S11 NO DETECTED.

S2 NO DETECTED.

S6 DETECTED. 2 result at SystemTime: 1602686497634
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#M3 and http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PL1 are involved in situation S6
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#M3 and http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PL1 are involved in situation S6
CAUSE DETERMINATION DONE.


S9 NO DETECTED.

S13 NO DETECTED.

S8 NO DETECTED.

S7 NO DETECTED.

S5 NO DETECTED.

S10 NO DETECTED.

S4 NO DETECTED.

S12 NO DETECTED.
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-2 . (1602686498931)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#R_Pangle . (1602686498975)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-2 . (1602686498975)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 3^^http://www.w3.org/2001/XMLSchema#double . (1602686499013)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-2 . (1602686499013)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-2 . (1602686499013)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_Pangle-2 . (1602686499038)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-2 . (1602686499038)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-2 . (1602686499038)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-2 . (1602686499038)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#T_temp . (1602686499129)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-2 . (1602686499103)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#C_Wtemp . (1602686499103)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-2 . (1602686499072)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-2 . (1602686499072)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-2 . (1602686499072)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-2 . (1602686499072)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_Pangle-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:38.931^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686499072)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-2 . (1602686499039)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-2 . (1602686499038)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-2 . (1602686499038)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PowerOutput . (1602686499324)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_speed . (1602686499349)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#C_temp . (1602686499279)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 63^^http://www.w3.org/2001/XMLSchema#double . (1602686499235)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_current . (1602686499210)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#P_temp . (1602686499185)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#GB_temp . (1602686499160)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#Conv_temp . (1602686499381)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#OilTemp . (1602686499414)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 35^^http://www.w3.org/2001/XMLSchema#double . (1602686499459)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_OilTemp-2 . (1602686499489)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_OilTemp-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:39.072^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686499519)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 49^^http://www.w3.org/2001/XMLSchema#double . (1602686499544)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 87^^http://www.w3.org/2001/XMLSchema#double . (1602686499569)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 47^^http://www.w3.org/2001/XMLSchema#double . (1602686499659)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_Wtemp-2 . (1602686499684)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 782^^http://www.w3.org/2001/XMLSchema#double . (1602686499660)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 32^^http://www.w3.org/2001/XMLSchema#double . (1602686499741)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 496^^http://www.w3.org/2001/XMLSchema#double . (1602686499741)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 1482^^http://www.w3.org/2001/XMLSchema#double . (1602686499765)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#E_temp . (1602686499805)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#R_speed . (1602686499805)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#TG_temp . (1602686499854)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_temp . (1602686499830)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 17^^http://www.w3.org/2001/XMLSchema#double . (1602686499906)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_PowerOutput-2 . (1602686499932)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_PowerOutput-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:39.038^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686499976)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_speed-2 . (1602686500038)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_speed-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:39.072^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686500070)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_temp-2 . (1602686500165)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_P_temp-2 . (1602686500198)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_current-2 . (1602686500223)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 63^^http://www.w3.org/2001/XMLSchema#double . (1602686500250)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_Wtemp-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:38.975^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686500250)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_Conv_temp-2 . (1602686500274)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_T_temp-2 . (1602686500306)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_T_temp-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:39.013^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686500401)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_GB_temp-2 . (1602686500432)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_current-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:39.038^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686500495)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_P_temp-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:39.013^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686500522)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_temp-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:39.072^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686500555)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_E_temp-2 . (1602686500616)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 275^^http://www.w3.org/2001/XMLSchema#double . (1602686500704)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 40^^http://www.w3.org/2001/XMLSchema#double . (1602686500680)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 39^^http://www.w3.org/2001/XMLSchema#double . (1602686500680)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_Conv_temp-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:39.038^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686500856)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_GB_temp-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:39.038^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686500818)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_E_temp-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:39.038^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686500731)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_temp-2 . (1602686500884)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_speed-2 . (1602686500909)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_TG_temp-2 . (1602686501027)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_TG_temp-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:39.039^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686501064)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_speed-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:39.103^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686501131)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_temp-2 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:39.072^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686501193)

S1 NO DETECTED.

S3 NO DETECTED.

S14 NO DETECTED.

S11 NO DETECTED.

S2 NO DETECTED.

S6 DETECTED. 2 result at SystemTime: 1602686502723
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#M3 and http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PL1 are involved in situation S6
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#M3 and http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PL1 are involved in situation S6
CAUSE DETERMINATION DONE.


S9 NO DETECTED.

S13 NO DETECTED.

S8 NO DETECTED.

S7 NO DETECTED.

S5 NO DETECTED.

S10 NO DETECTED.

S4 NO DETECTED.

S12 NO DETECTED.
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-3 . (1602686507374)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PowerOutput . (1602686507434)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-3 . (1602686507434)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 208^^http://www.w3.org/2001/XMLSchema#double . (1602686507464)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-3 . (1602686507492)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-3 . (1602686507492)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-3 . (1602686507492)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-3 . (1602686507492)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-3 . (1602686507490)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-3 . (1602686507490)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#C_temp . (1602686507490)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-3 . (1602686507493)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_PowerOutput-3 . (1602686507533)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-3 . (1602686507533)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-3 . (1602686507533)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_PowerOutput-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.374^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686507559)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-3 . (1602686507559)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-3 . (1602686507559)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#R_speed . (1602686507586)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-3 . (1602686507586)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-3 . (1602686507588)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#R_Pangle . (1602686507630)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#T_temp . (1602686507660)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_temp . (1602686507697)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#C_Wtemp . (1602686507724)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#OilTemp . (1602686507757)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#GB_temp . (1602686507792)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#TG_temp . (1602686507819)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#P_temp . (1602686507845)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#Conv_temp . (1602686507913)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 51^^http://www.w3.org/2001/XMLSchema#double . (1602686507940)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_speed . (1602686507986)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 507^^http://www.w3.org/2001/XMLSchema#double . (1602686508025)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_current . (1602686508086)

S1 NO DETECTED.
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_speed-3 . (1602686508444)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 61^^http://www.w3.org/2001/XMLSchema#double . (1602686508444)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 58^^http://www.w3.org/2001/XMLSchema#double . (1602686508276)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 49^^http://www.w3.org/2001/XMLSchema#double . (1602686508444)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 34^^http://www.w3.org/2001/XMLSchema#double . (1602686508444)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 9^^http://www.w3.org/2001/XMLSchema#double . (1602686508364)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 35^^http://www.w3.org/2001/XMLSchema#double . (1602686508418)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 52^^http://www.w3.org/2001/XMLSchema#double . (1602686508392)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 45^^http://www.w3.org/2001/XMLSchema#double . (1602686508303)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 57^^http://www.w3.org/2001/XMLSchema#double . (1602686508276)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_Conv_temp-3 . (1602686508156)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#E_temp . (1602686508118)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 45^^http://www.w3.org/2001/XMLSchema#double . (1602686508118)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 999^^http://www.w3.org/2001/XMLSchema#double . (1602686508478)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_Pangle-3 . (1602686508512)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_Pangle-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.492^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686508550)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_TG_temp-3 . (1602686508579)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_T_temp-3 . (1602686508633)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_GB_temp-3 . (1602686508664)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_OilTemp-3 . (1602686508693)

S3 NO DETECTED.
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_P_temp-3 . (1602686509052)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_temp-3 . (1602686509052)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_Wtemp-3 . (1602686508991)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_speed-3 . (1602686509022)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_Conv_temp-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.588^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686508958)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 27^^http://www.w3.org/2001/XMLSchema#double . (1602686508911)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_temp-3 . (1602686508876)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_current-3 . (1602686508848)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_TG_temp-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.533^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686508812)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_temp-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.559^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686509178)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_T_temp-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.559^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686508786)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_GB_temp-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.492^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686508753)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_speed-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.493^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686508720)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_Wtemp-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.49^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686509150)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_P_temp-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.533^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686509117)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_OilTemp-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.492^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686509084)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_current-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.49^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686509216)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_temp-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.434^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686509280)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_E_temp-3 . (1602686509344)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_speed-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.492^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686509408)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_E_temp-3 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:47.586^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686509472)

S14 NO DETECTED.

S11 NO DETECTED.

S2 NO DETECTED.

S6 NO DETECTED.

S9 NO DETECTED.

S13 NO DETECTED.

S8 NO DETECTED.

S7 NO DETECTED.

S5 NO DETECTED.

S10 NO DETECTED.

S4 NO DETECTED.

S12 NO DETECTED.

S1 NO DETECTED.

S3 NO DETECTED.

S14 NO DETECTED.

S11 NO DETECTED.

S2 NO DETECTED.

S6 NO DETECTED.

S9 NO DETECTED.

S13 NO DETECTED.

S8 NO DETECTED.

S7 NO DETECTED.

S5 NO DETECTED.

S10 NO DETECTED.

S4 NO DETECTED.

S12 NO DETECTED.
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-4 . (1602686515777)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PowerOutput . (1602686515839)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 1880^^http://www.w3.org/2001/XMLSchema#double . (1602686515878)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_PowerOutput-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_PowerOutput-4 . (1602686515912)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_PowerOutput-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:55.777^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686515946)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-4 . (1602686515946)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-4 . (1602686515980)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-4 . (1602686515980)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-4 . (1602686515980)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-4 . (1602686515980)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-4 . (1602686515980)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-4 . (1602686515980)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-4 . (1602686515980)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#R_Pangle . (1602686516036)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 9^^http://www.w3.org/2001/XMLSchema#double . (1602686516083)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-4 . (1602686516083)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-4 . (1602686516083)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_current . (1602686516121)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-4 . (1602686516083)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-4 . (1602686516083)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-4 . (1602686516083)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp http://semanticweb.org/STEaMINg/ContextOntology-COInd4#madeObservation http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-4 . (1602686516083)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#C_Wtemp . (1602686516184)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_speed . (1602686516155)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#OilTemp . (1602686516215)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#T_temp . (1602686516247)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#GB_temp . (1602686516293)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#P_temp . (1602686516319)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#G_temp . (1602686516346)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 36^^http://www.w3.org/2001/XMLSchema#double . (1602686516371)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 55^^http://www.w3.org/2001/XMLSchema#double . (1602686516426)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 49^^http://www.w3.org/2001/XMLSchema#double . (1602686516426)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 447^^http://www.w3.org/2001/XMLSchema#double . (1602686516490)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_GB_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_GB_temp-4 . (1602686516463)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 89^^http://www.w3.org/2001/XMLSchema#double . (1602686516520)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#TG_temp . (1602686516574)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#R_speed . (1602686516574)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#E_temp . (1602686516601)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#Conv_temp . (1602686516636)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#observedProperty http://semanticweb.org/STEaMINg/ContextOntology-COInd4#C_temp . (1602686516688)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 800^^http://www.w3.org/2001/XMLSchema#double . (1602686516662)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_Pangle-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_Pangle-4 . (1602686516715)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 28^^http://www.w3.org/2001/XMLSchema#double . (1602686517038)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 163^^http://www.w3.org/2001/XMLSchema#double . (1602686517038)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 50^^http://www.w3.org/2001/XMLSchema#double . (1602686517038)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_temp-4 . (1602686516986)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 35^^http://www.w3.org/2001/XMLSchema#double . (1602686516958)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_speed-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_speed-4 . (1602686516958)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_GB_temp-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:55.98^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686516958)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_Wtemp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_Wtemp-4 . (1602686516893)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 38^^http://www.w3.org/2001/XMLSchema#double . (1602686516866)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 30^^http://www.w3.org/2001/XMLSchema#double . (1602686516837)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasSimpleResult 85^^http://www.w3.org/2001/XMLSchema#double . (1602686516768)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_P_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_P_temp-4 . (1602686517178)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_temp-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:55.98^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686517152)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_Pangle-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:55.946^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686517126)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_T_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_T_temp-4 . (1602686517009)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_G_current-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_current-4 . (1602686517094)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_R_speed-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_speed-4 . (1602686517210)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_R_speed-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:56.083^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686517257)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_E_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_E_temp-4 . (1602686517283)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_T_temp-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:55.98^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686517362)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_current-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:55.98^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686517362)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_P_temp-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:55.98^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686517434)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_Conv_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_Conv_temp-4 . (1602686517495)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_C_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_temp-4 . (1602686517553)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_temp-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:56.083^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686517582)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_OilTemp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_OilTemp-4 . (1602686517698)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_Conv_temp-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:56.083^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686517698)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_G_speed-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:55.98^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686517698)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_C_Wtemp-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:55.98^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686517698)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#S_TG_temp-Obs-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasTime http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_TG_temp-4 . (1602686517618)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_E_temp-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:56.083^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686517844)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_TG_temp-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:56.083^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686517926)
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#t-obs-S_OilTemp-4 http://semanticweb.org/STEaMINg/ContextOntology-COInd4#inXSDDateTime 2020-10-14 16:41:56.083^^http://www.w3.org/2001/XMLSchema#dateTimeStamp . (1602686518055)

S1 NO DETECTED.

S3 NO DETECTED.

S14 NO DETECTED.

S11 NO DETECTED.

S2 NO DETECTED.

S6 DETECTED. 1 result at SystemTime: 1602686518260
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#M3 and http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PL1 are involved in situation S6
CAUSE DETERMINATION DONE.


S9 NO DETECTED.

S13 NO DETECTED.

S8 NO DETECTED.

S7 DETECTED. 1 result at SystemTime: 1602686518761
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#M3 and http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PL1 are involved in situation S7
CAUSE DETERMINATION DONE.


S5 NO DETECTED.

S10 DETECTED. 2 result at SystemTime: 1602686519013
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#M3 and http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PL1 are involved in situation S10
http://semanticweb.org/STEaMINg/ContextOntology-COInd4#M3 and http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PL1 are involved in situation S10
CAUSE DETERMINATION DONE.


S4 NO DETECTED.

S12 NO DETECTED.
```
