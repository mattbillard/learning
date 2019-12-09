students = [["Will", "B"], ["Kate", "B"], ["Max", "A"], ["Elsa", "C"], ["Alex", "B"], ["Chris", "A"]]

results = [student[0] for student in students if student[1] == "A"]

print(results)
