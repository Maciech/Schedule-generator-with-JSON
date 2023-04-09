# Schedule generator with JSON
## _Data read convert analyze result_

The schedule generator is a tool to optimize the way orders are fulfilled in the store.
Orders are read from JSON files. They consist of:
- Order ID,
- Order value,
- Time needed to complete and pack the order,
- The time by which the order must be completed.

After reading the parameters, they are analyzed.
Orders are placed in the correct order depending on the sorting method.
The final result of the program is a schedule consisting of:
- Employee ID,
- Order number,
- The time of completing the packing of the order,
- Order value.
_So far, the best method was to sort by performance,
that is converting the value of the order by the time needed to complete the order_

### Technologies
Scheduler was prepared using:
- IntelliJ IDEA development environment,
- OpenJdk 18.0.2
- Bundled Maven 3.8.1
