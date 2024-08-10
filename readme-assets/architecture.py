from diagrams import Diagram, Cluster
from diagrams.k8s.network import Service
from diagrams.onprem.database import PostgreSQL
from diagrams.programming.framework import Spring

with Diagram("Establishment Manager Architecture", show=False):
    ingress = Service("API Gateway")
    student_db = PostgreSQL("Student Database")
    school_db = PostgreSQL("School Database")

    with Cluster("Services"):
        student_service = Spring("Student Service")
        school_service = Spring("School Service")


    ingress >> student_service
    ingress >> school_service
    student_service >> student_db
    school_service >> school_db