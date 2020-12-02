variable "vpc_id" {
  description = "VPC ID to be overridden"
}

variable "vpccidr" {
  description = "VPC CIDR to be overridden"
}

variable "ports" {
  type = map(number)
  default = {
    80 = 80,
    22 = 22,
    8080 = 8080,
    3306 = 3306,
    5000 = 5001
  }  
}