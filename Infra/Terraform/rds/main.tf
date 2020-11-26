resource "aws_db_instance" "rds1" {
    #vpc_id = var.vpc_id
    instance_class = "db.t2.micro"
    engine = "mysql"
    engine_version = "5.7.31"
    allocated_storage = 20
    db_subnet_group_name = var.rds_subnet_grp_id
    vpc_security_group_ids = var.security_group_ids
    username = "root"
    password = "password"
    skip_final_snapshot = true
}

