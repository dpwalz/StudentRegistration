names = """abugg|LluUUa|Aida Bugg|100003
mbiologist|kAZjDl|Maureen Biologist|100004
tdactyl|DXMQTJ|Teri Dactyl|100005
plegge|jnJntX|Peg Legge|100006
agrater|DZJCBs|Allie Grater|100007
lerd|qBKVrD|Liz Erd|100008
amused|rCwHoR|A. Mused|100009
cnoring|Usuivs|Constance Noring|100010
rsin|yiUzCa|Ray Sin|100011
iringing|sNMKyo|Isabelle Ringing|100012
esideways|REHXwa|Eileen Sideways|100013
rbook|TebHjq|Rita Book|100014
pturner|AiDZna|Paige Turner|100015
rreport|JoJcrR|Rhoda Report|100016
awind|rHVkHH|Augusta Wind|100017
canthemum|SVXvfl|Chris Anthemum|100018
ateak|ayhnEc|Anne Teak|100019
unice|izDnxL|U.R. Nice|100020
abath|aYDakQ|Anita Bath|100021
hupp|DLkZNx|Harriet Upp|100022
itired|QLcrGl|I.M. Tired|100023
aletterback|enAKAl|Anita Letterback|100024
hfuraletter|uOXMzk|Hope Furaletter|100025
bhomesoon|YYjlQr|B. Homesoon|100026
bmine|UdVsod|Bea Mine|100027
btwishes|oRuKNf|Bess Twishes|100028
cyasoon|ltZspJ|C. Yasoon|100029
ayose|LCZgNI|Audie Yose|100030
dend|xWTPyn|Dee End|100031
ahug|QNxYli|Amanda Hug|100032
bdover|HBTdVp|Ben Dover|100033
edover|STUobZ|Eileen Dover|100034
wmakit|czYhfQ|Willie Makit|100035
wfindit|XhCEKj|Willie Findit|100036
sblue|teeFxN|Skye Blue|100037
sclowd|NyTZKr|Staum Clowd|100038
aminstra|pAhvYg|Addie Minstra|100039
aortha|lkExfq|Anne Ortha|100040
dallippa|SklbUK|Dave Allippa|100041
dzynah|UzsYYK|Dee Zynah|100042
hmannerizorsa|qHzxfw|Hugh Mannerizorsa|100043
llyzayta|Dcmxpf|Loco Lyzayta|100044
mjah|cOIQWo|Manny Jah|100045
mateer|tZGzfb|Mark Ateer|100046
rewer|cwkJgX|Reeve Ewer|100047
tryta|ggNxlI|Tex Ryta|100048
tgreen|qPHJhk|Theresa Green|100049
bkade|yOVTxn|Barry Kade|100050
sdupp|aFfWHp|Stan Dupp|100051
ndown|mAEGEa|Neil Down|100052
ctrariweis|zqkXLO|Con Trariweis|100053
dmesswidme|lCbBXP|Don Messwidme|100054
aannon|JoExcj|Al Annon|100055
adomino|HbdXna|Anna Domino|100056
cstale|mgfEFC|Clyde Stale|100057
alogwatch|ySejPO|Anna Logwatch|100058
alittlical|mgpJdx|Anna Littlical|100059
smeebuggah|wfrhMg|Sly Meebuggah|100060
sgoodmate|nyXawQ|Saul Goodmate|100061
fclether|AMgEtf|Faye Clether|100062
smoanees|XfrlqR|Sarah Moanees|100063"""

student_id = 10000003
output = ""
# ("garnet.crookes", "1234", "Garnet", "Crookes", "10000000", "ENGINEERING"),
for name in names.split("\n"):
	array = name.split("|")
	username = array[0]
	password = array[1]
	FName, LName = array[2].split()
	id = student_id
	student_id += 1

	output += f'("{username}", "{password}", "{FName}", "{LName}", {id}, "Engineering"),\n'

print(output) 

