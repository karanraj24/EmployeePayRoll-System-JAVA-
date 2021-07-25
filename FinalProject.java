import java.util.ArrayList;
import java.util.Scanner;

interface Iprintable
{
    String printMyData();
}

abstract class Vehicle implements Iprintable
{
    protected String make;
    protected double plate;

    public Vehicle(String make,double plate)
    {
        this.make = make;
        this.plate = plate;
    }

    public Vehicle() {
    }

    public String getMake()
    {
        return make;
    }
    public double getPlate()
    {
        return plate;
    }

    public void setMake(String make)
    {
        this.make = make;
    }
    public void setPlate(double plate)
    {
        this.plate = plate;
    }
    @Override
    public String printMyData() {
        System.out.println("Car make: "+make+"Car Plate: "+plate);
        return null;
    }
}

class Car extends Vehicle implements Iprintable
{

    private String carname;
    private String carcolor;

    public Car(String make,double plate,String carname,String carcolor)
    {
        super(make,plate);
        this.carname = carname;
        this.carcolor = carcolor;
    }

    public Car() {
        super();
    }

    public String getCarname()
    {
        return carname;
    }
    public String getCarcolor()
    {
        return carcolor;
    }

    public void setCarname(String carname)
    {
        this.carname = carname;
    }
    public void setCarcolor(String carcolor)
    {
        this.carcolor = carcolor;
    }

    @Override
    public String printMyData() {
        System.out.println("Employee Has a Car.");
        System.out.println("Car make: "+make+"Car Plate: "+plate+"Car Name: "+carname+"Car colour: "+carcolor);
        return null;
    }
}

class Motorcycle extends Vehicle implements Iprintable
{
    private String motorcyclename;
    private String motorcyclecolor;

    public Motorcycle(String make,double plate,String motorcyclename,String motorcyclecolor)
    {
        super(make,plate);
        this.motorcyclename = motorcyclename;
        this.motorcyclecolor = motorcyclecolor;
    }
    public String getMotorcyclename()
    {
        return motorcyclename;
    }
    public String getMotorcyclecolor()
    {
        return motorcyclecolor;
    }

    public void setMotorcyclename(String motorcyclename)
    {
        this.motorcyclename = motorcyclename;
    }
    public void setMotorcyclecolor(String motorcyclecolor)
    {
        this.motorcyclecolor = motorcyclecolor;
    }

    @Override
    public String printMyData() {
        System.out.println("Employee Has a Motorcycle.");
        System.out.println("Car make: "+make+"Car Plate: "+plate+"Motorcycle Name: "+motorcyclename+"Motorcycle colour: "+motorcyclecolor);
        return null;
    }
}

abstract class Employee implements Iprintable
{
    protected String empname;
    protected int empage;

    public Employee(String empname,int empage)
    {
        this.empname = empname;
        this.empage = empage;
    }

    public String getEmpname()
    {
        return empname;
    }
    public int getEmpage()
    {
        return empage;
    }

    public void setEmpname(String empname)
    {
        this.empname = empname;
    }
    public void setEmpage(int empage)
    {
        this.empage = empage;
    }

    public String getEmployee()
    {
        return null;
    }

    @Override
    public String printMyData()
    {
        return "Employee Name= " + empname +
                "Employee age= " + empage
                ;
    }
    public double calcBirthYear()
    {
        return 2021-empage;
    }

    public double calcEarnings()
    {
        return 1000;
    }
}

abstract class PartTime extends Employee implements Iprintable {


    private int rate;
    private int hoursworked;

    public PartTime(String empname,int empage,int rate,int hoursworked)
    {
        super(empname,empage);
        this.rate = rate;
        this.hoursworked = hoursworked;
    }

    public int getRate()
    {
        return rate;
    }
    public int getHoursworked()
    {
        return hoursworked;
    }

    public void setRate(int rate)
    {
        this.rate = rate;
    }
    public void setHoursworked(int hoursworked)
    {
        this.hoursworked = hoursworked;
    }
    @Override
    public String getEmployee()
    {
        return null;
    }
    @Override
    public String printMyData()
    {
        return "Rate= " + rate +
                "Hours Worked= " + hoursworked
                ;
    }

    @Override
    abstract public double calcEarnings();
}

class CommissionBasedPartTime extends PartTime implements Iprintable{

    private int commission;

    public CommissionBasedPartTime(String empname,int empage,int rate,int hoursworked,int commission)
    {
        super(empname,empage,rate,hoursworked);
        this.commission = commission;
    }


    public int getCommission()
    {
        return commission;
    }
    public void setCommission(int commission)
    {
        this.commission = commission;
    }

    @Override
    public String getEmployee()
    {
        return "Employee is Part-Time | Commissioned Based";
    }
    @Override
    public String printMyData()
    {
        return "rate= " + getRate() +
                "\nHours Worked= " + getHoursworked() +
                "\nCommission= " + commission;
    }

    @Override
    public double calcEarnings() {
        return (((getRate()*getHoursworked())+(0.2*getRate()*getHoursworked())));
    }
}

class FixedBasedPartTime extends PartTime implements Iprintable
{
    private int fixedamount;

    public FixedBasedPartTime(String empname,int empage,int rate,int hoursworked,int fixedamount)
    {
        super(empname,empage,rate,hoursworked);
        this.fixedamount = fixedamount;
    }

    public int getCommission()
    {
        return fixedamount;
    }
    public void setCommission(int fixedamount)
    {
        this.fixedamount = fixedamount;
    }

    @Override
    public String getEmployee()
    {
        return "Employee is Part-Time | FixedAmount Based";
    }
    @Override
    public String printMyData()
    {
        return "rate='" + getRate() + '\'' +
                "\nHours Worked= " + getHoursworked() +
                "\nFixed Rate= " + fixedamount;
    }

    @Override
    public double calcEarnings() {
        return ((getRate()*getHoursworked())+fixedamount);
    }
}

class Intern extends Employee implements Iprintable
{

    private String schoolname;

    public Intern(String empname,int empage,String schoolname)
    {
        super(empname,empage);
        this.schoolname = schoolname;
    }

    public String getSchoolname()
    {
        return schoolname;
    }
    public void setSchoolname(String schoolname)
    {
        this.schoolname = schoolname;
    }

    @Override
    public String getEmployee()
    {
        return "Employee is an Intern";
    }
    @Override
    public String printMyData()
    {
        return "School Name= " + schoolname;
    }

    @Override
    public double calcEarnings()
    {
        return 1000;
    }

}

class FullTime extends Employee implements Iprintable
{

    private double salary;
    private double bonus;

    public FullTime(String empname,int empage,double salary,double bonus)
    {
        super(empname,empage);
        this.salary = salary;
        this.bonus = bonus;
    }

    public double getSalary()
    {
        return salary;
    }
    public double getBonus()
    {
        return bonus;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    public void setBonus(double bonus)
    {
        this.bonus = bonus;
    }
    @Override
    public String getEmployee()
    {
        return "Employee is Full-Time";
    }
    @Override
    public String printMyData()
    {
        return "Salary= " + salary +
                "\nBonus= " + bonus;

    }

    @Override
    public double calcEarnings()
    {
        return (salary+bonus);
    }

}


public class FinalProject {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        ArrayList<Employee> EmployeeDetails = new ArrayList<>();
        String[] vehiclemake = new String[10];
        String[] vehicleplate = new String[10];
        String[] vehiclename = new String[10];
        String[] vehiclecolor = new String[10];
        String[] vehtype = new String[10];
        int count = 0;
        do {
            System.out.println("Enter Employee Name: ");
            String employeename = sc.next();
            System.out.println("Enter Employee Age: ");
            int employeege = sc.nextInt();
            System.out.println("Do you have Vehicle?(y/n): ");
            String choose = sc.next();
            if (choose.equals("y"))
            {
                System.out.println("Enter Vehicle Make: ");
                String carmake = sc.next();
                System.out.println("Enter Vehicle Plate: ");
                String carplate = sc.next();
                System.out.println("What Vehicle Do you have:\t1.Car\t2.Motorcycle");
                int select2 = sc.nextInt();
                switch (select2)
                {
                    case 1:
                    {
                        System.out.println("Enter Car Name: ");
                        String carname = sc.next();
                        System.out.println("Enter Car Colour: ");
                        String carcolor = sc.next();
                        vehiclemake[count] = carmake;
                        vehicleplate[count] = carplate;
                        vehiclename[count] = carname;
                        vehiclecolor[count] = carcolor;
                        vehtype[count]="car";
                        count = count+1;
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Enter Motorcycle Name: ");
                        String motorcyclename = sc.next();
                        System.out.println("Enter Motorcycle Colour: ");
                        String motorcyclecolor = sc.next();
                        vehiclemake[count] = carmake;
                        vehicleplate[count] = carplate;
                        vehiclename[count] = motorcyclename;
                        vehiclecolor[count] = motorcyclecolor;
                        vehtype[count]="motorcycle";
                        count = count+1;
                        break;
                    }
                    default:
                    {
                        System.out.println("Employee has no vehicle Registered.");
                        break;
                    }
                }
            }
            else
            {
                System.out.println("Employee has no vehicle.");
            }
            System.out.println("Select Job Type:\t1. Part-time\t2. Intern\t3. Full-time");
            int select = sc.nextInt();
            switch (select)
            {
                case 1:
                {
                    System.out.println("Enter Rate: ");
                    int employeerate = sc.nextInt();
                    System.out.println("Enter HoursWorked: ");
                    int employeehoursworked = sc.nextInt();
                    System.out.println("Select Part-Time:\t1. Commissioned-Based\t2. Fixed-Based");
                    int select1 = sc.nextInt();
                    switch (select1)
                    {
                        case 1:
                        {
                            System.out.println("Enter the commission: ");
                            int employeecommission = sc.nextInt();
                            EmployeeDetails.add(new CommissionBasedPartTime(employeename,employeege,employeerate,employeehoursworked,employeecommission));
                            break;
                        }
                        case 2:
                        {
                            System.out.println("Enter the Fixed Rate: ");
                            int employeefixedrate = sc.nextInt();
                            EmployeeDetails.add(new FixedBasedPartTime(employeename,employeege,employeerate,employeehoursworked,employeefixedrate));
                            break;
                        }
                        default:
                        {
                            System.out.println("Wrong Entry! Please Select from given Option.");
                            break;
                        }
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("Enter School Name: ");
                    String employeeschoolname = sc.next();
                    EmployeeDetails.add(new Intern(employeename,employeege,employeeschoolname));
                    break;
                }
                case 3:
                {
                    System.out.println("Enter Your Salary: ");
                    double employeesalary = sc.nextDouble();
                    System.out.println("Enter Your Bonus: ");
                    double employeebonus = sc.nextDouble();
                    EmployeeDetails.add(new FullTime(employeename,employeege,employeesalary,employeebonus));
                    break;
                }
                default:
                {
                    System.out.println("Wrong Entry! Please select from given option.");
                    break;
                }
            }
            System.out.println("Do you want to add more:(yes/no): ");
        }while (sc.next().equals("yes"));
        double Totalearnings = 0.0;
        for (int i=0;i<EmployeeDetails.size();i++)
        {
            System.out.println("Name: "+EmployeeDetails.get(i).empname);
            System.out.println("Year of Birth: "+EmployeeDetails.get(i).calcBirthYear());
            if (vehtype[i]=="car")
            {
                System.out.println("Employee has car.");
                System.out.println("Make: "+vehiclemake[i]);
                System.out.println("Plate: "+vehicleplate[i]);
                System.out.println("Car Name: "+vehiclename[i]);
                System.out.println("Car Colour: "+vehiclecolor[i]);
            }
            else if (vehtype[i]=="motorcycle")
            {
                System.out.println("Employee has motorcycle.");
                System.out.println("Make: "+vehiclemake[i]);
                System.out.println("Plate: "+vehicleplate[i]);
                System.out.println("Motorcycle Name: "+vehiclename[i]);
                System.out.println("Motorcycle Colour: "+vehiclecolor[i]);
            }
            else
            {
                System.out.println("Employee has no Vehicle.");
            }
            System.out.println(EmployeeDetails.get(i).getEmployee());
            System.out.println(EmployeeDetails.get(i).printMyData());
            System.out.println("Earnings: "+EmployeeDetails.get(i).calcEarnings());
            Totalearnings = Totalearnings+EmployeeDetails.get(i).calcEarnings();
            System.out.println("\n............................................\n");
        }

        System.out.println("Total Earnings: "+Totalearnings+" Canadian Dollars.");
    }
}
