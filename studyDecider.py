class StudyDecider:
    def __init__(self):
        self.num_of_classes = 0
        self.grades = []
        self.classes = []

    def update_elements(self, new_grades):
        for i in range(len(self.grades)):
            self.grades[i] += new_grades[i]

    def set_classes_num(self, num):
        return list(range(num))

    def rate_classes(self, arr, classes_num):
        # Bubble sort (descending order)
        for i in range(len(arr) - 1):
            for j in range(len(arr) - 1 - i):
                if arr[j] < arr[j + 1]:
                    arr[j], arr[j + 1] = arr[j + 1], arr[j]
                    classes_num[j], classes_num[j + 1] = classes_num[j + 1], classes_num[j]
        return arr

    def ask_questions(self, question, names, grades):
        print(question)
        for i, name in enumerate(names):
            am = int(input(f"{name}: "))
            grades[i] += am

    def link_lists(self, nums, lst):
        new_list = [None] * len(lst)
        for i, idx in enumerate(nums):
            new_list[idx] = lst[i]
        return new_list

    def print_list(self, grades):
        for g in grades:
            print(g)

    def print_slist(self, names):
        for n in names:
            print(n)

    def set_num_of_classes(self, num):
        self.num_of_classes = num


def main():
    sd = StudyDecider()

    num = int(input("Type how many subjects you have and want to study: "))
    if num == 1:
        print("Study this one subject..")
        return

    sd.set_num_of_classes(num)

    print("\nType names of subjects: ")
    names = [input().strip() for _ in range(num)]

    print("\n========================================================")
    print("Now you will rate some things carefully. You can always rerun if you change your mind.")
    print("========================================================\n")

    print(f"Rate from 1-{num} (with 1 being the lowest score):\n")
    grades = [0] * num

    questions = [
        f"How much stuff is there to study for each subject ({num}:a lot,1:basically nothing)",
        f"Which one is closer date-wise ({num}:really close,1:far far)",
        f"How well do you already know each class({num}:studied all year, 1:haven't ever studied it)",
        f"How easy is the class overall ({num}:very hard,1:very easy)",
        f"How hard are the exams ({num}:very hard,1:very easy)"
    ]

    for q in questions:
        sd.ask_questions(q, names, grades)

    classes_num = sd.set_classes_num(num)
    sd.rate_classes(grades, classes_num)
    final_list = sd.link_lists(classes_num, names)

    print("\n******************** computing.... ****************\n")
    print("Here’s what you graded in order from max points to least points:")
    sd.print_list(grades)

    print("\n========================================================")
    print("Here’s the order from MOST to LEAST significant class to study:")
    sd.print_slist(final_list)


if __name__ == "__main__":
    main()
