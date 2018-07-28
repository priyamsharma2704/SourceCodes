import json
from pprint import pprint
import xlsxwriter

with open('data.json') as f:
    data = json.load(f)

#pprint(data)
pprint(data['b2b'][0])

# #85 items
# Create an new Excel file and add a worksheet.
workbook = xlsxwriter.Workbook('demo.xlsx')
worksheet = workbook.add_worksheet()
                #r  #c
worksheet.write(3, 0, 123.456)

for i in range (0,85):
    item = data['b2b'][i]
    leng = len(data['b2b'][i]) #4
    print(leng)
    for k in item:
        f = 0
        print (item['ctin'])
        inv = item['inv']
        worksheet.write(i, f, item['ctin'])
        f=f+1
        worksheet.write(i, f, item['cfs'])
        f=f+1
        for j in inv:
            print (j['itms'])
            print(j['idt'])
            itms = j['itms']
            worksheet.write(i, f, j['idt'])
            f= f+1
            worksheet.write(i, f, j['inum'])
            f=f+1
            worksheet.write(i, f, j['val'])
            f=f+1
            worksheet.write(i, f, j['pos'])
            f=f+1
            worksheet.write(i, f, j['inv_typ'])
            f=f+1
            for x in itms:
                print(x['num'])
                print(x['itc'])
                print(x['itm_det'])
workbook.close()
