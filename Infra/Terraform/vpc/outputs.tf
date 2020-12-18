output "vpc_id" {
  value = aws_vpc.taskVPC.id
}

output "vpc_cidr" {
  value = aws_vpc.taskVPC.cidr_block
}