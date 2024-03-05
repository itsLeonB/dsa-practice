class ListNode:
    def __init__(self, value: int = 0, next_node=None):
        self.value = value
        self.next_node = next_node


def add_two_numbers(list1: ListNode, list2: ListNode) -> ListNode:
    head = ListNode(0)
    tail = head
    carry = 0

    while list1 is not None or list2 is not None or carry != 0:
        digit1 = list1.value if list1 is not None else 0
        digit2 = list2.value if list2 is not None else 0
        total = digit1 + digit2 + carry
        new_digit = total % 10
        carry = total // 10

        new_node = ListNode(new_digit)
        tail.next_node = new_node
        tail = tail.next_node
        list1 = list1.next_node if list1 is not None else None
        list2 = list2.next_node if list2 is not None else None

    return head.next_node


def print_list(head: ListNode) -> list:
    arr = []
    while head is not None:
        arr.append(head.value)
        head = head.next_node
    print(arr)


def main():
    number1 = input().split()
    node1 = ListNode(0)
    tail1 = node1
    for num in number1:
        new_node = ListNode(int(num))
        tail1.next_node = new_node
        tail1 = tail1.next_node

    number2 = input().split()
    node2 = ListNode(0)
    tail2 = node2
    for num in number2:
        new_node = ListNode(int(num))
        tail2.next_node = new_node
        tail2 = tail2.next_node

    print_list(add_two_numbers(node1.next_node, node2.next_node))


if __name__ == "__main__":
    main()

