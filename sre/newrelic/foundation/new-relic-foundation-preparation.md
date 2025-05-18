# New Relic Foundation Preparation Resume

### What is monitoring?

**Monitoring** is the act of collecting regular data about systems so performance can be viewed and tracked.
The goal of monitoring is to quickly know when something goes wrong so it can be resolved before impacting users and business functions. The type of monitoring most common today is called **application performance monitoring (or APM)**

Imagine have you ever seen a baby in a monitor, monitoring modern applications is a bit like monitoring a baby.

But instead of reviewing audio or video data, enginners monitor numerical data points like traffic rates, how much of their available computing power is in use, load times, and more. Just like using a baby monitor, they'll know immediately when a meltdown occurs.

#### The three questions of monitoring

With monitoring in place, teams can ask three important questions:

1. Is our service online and available?
2. Is our service functioning correctly?
3. Is our service performing well?

If the answer to any of these 3 questions is no, telemetry data is used to detect and resolve the issue. Most development and DevOps teams' success is measured by how long it takes them to do this, reflected in two key industry metrics.

Click through each tab below to learn more about metrics used to measure DevOps success:

##### MEAN TIME TO DETECTION (MTTD)

MTTD is the amount of time, on average, between the start of an issue and when teams become aware of it. This does not include time spent troubleshooting or fixing the issue.

##### MEAN TIME TO RESOLUTION (MTTR)

MTTR is the average amount of time between when an issue is detected, and when systems are fixed and operating normally again. Ideally this includes both time spent fixing the issue, and implementing proactive steps to prevent it from happening again.

### Methods of monitoring

There are many ways in which monitoring teams organize how they work. Let's explore some of the industry-standard approaches to monitoring:

**RED Method** (Request Driven)

*The word "Throughput" refers to the amount of work or data processed by a system, process, or component within a specific period of time. In the context of computing and networking, it often measures the rate at which data is successfully transmitted or processed, such as requests per second or bits per second.*

* Rate(Throughput) - Request per second
* Errors - Failed Requests
* Duration - (Latency) Transaction Response time

**USE Method** (Resource Driven)

* Utilisation - level of resource use, as time or % (disk i/o at 65% utilisation)
* Saturation - Resource Expiry - requests queue/drop (disk queue length) Zero=good
* Errors - Failed operations (disk write error) Zero=good

**Four Golden Signals method** (RED + S) Google SRE Handbook

"If you can only measure four metrics of your user-facing-system, focus on these four."

* Latency - Transaction Response Time
* Traffic(Throughput) - Number of Requests
* Errors
* Saturation - Resources at 100%

**Core Web Vitals**

* Largest Content Paint (perceived page load)
* First Input Delay (perceived responsiveness)
* Cumulative Layout Shift (perceived stability)

##### Match the monitoring methodology with the corresponding application layer.


| Method              | Layer                          |
| ------------------- | ------------------------------ |
| Core Web Vitals     | UX Layer                       |
| RED Method          | Service Layer                  |
| Four Golden Signals | Service & Infrastructure Layer |
| USE Method          | Infrastructure Layer           |


### What is observability?

#### Enter observability

Monitoring alone ins't enough for modern organizations and it's nearly impossible to monitor all potential issues in modern systems

Modern companies need a flexible scalable solution to provide holistic visibility of application performance across multiple services in one place! This comes in the form of ***observability***.

Observability is the practice of instrumenting systems to gather actionable data depicting not only when and where an issue occurred, but more importantly why it occurred.
