variable "vpc_id" {
  description = "VPC ID to be overriden"
}

variable "AZ_CIDR" {
  type = map
  default = {
    eu-west-1a = "10.0.1.0/24"
    eu-west-1b = "10.0.2.0/24"
    eu-west-1c = "10.0.3.0/24"
  }
}
