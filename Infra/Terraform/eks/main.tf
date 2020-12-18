resource "aws_eks_cluster" "project_cluster" {
    name = "project_cluster"
    role_arn = "arn:aws:iam::845508719419:role/EKS-SR"
    version = "1.17"
    vpc_config {
        subnet_ids =  [var.subnet_id, var.subnet2_id, var.subnet3_id]
        security_group_ids = var.security_group_ids
    }
}

resource "aws_eks_node_group" "node_group" {
    cluster_name = aws_eks_cluster.project_cluster.name
    node_group_name = "node_group"
    node_role_arn = "arn:aws:iam::845508719419:role/NodeRole"
    subnet_ids = [var.subnet_id, var.subnet2_id, var.subnet3_id]
    ami_type = "AL2_x86_64"
    instance_types = ["t3.small"]
    scaling_config {
        desired_size = "3" 
        max_size = "3"
        min_size = "3"
    }
}