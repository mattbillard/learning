students = {"Belov": ["Physics", "Math", "Russian"], "Smith": ["Math", "Geometry", "English"], "Sarada": ["Japanese", "Math", "Physics"]}
classes = set()

for key, value in students.items():
    for class_name in value:
        classes.add(class_name)

print(classes)